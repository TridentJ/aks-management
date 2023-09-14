/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/13
 * Time: 15:54
 **/
package com.aks.management.security;

import com.aks.management.bean.Role;
import com.aks.management.service.RoleService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    
    @Resource
    private SecurityUserDetailsService securityUserDetailsService;
    
    @Resource
    private AksAccessDeniedHandler aksAccessDeniedHandler;
    
    @Resource
    private RoleService roleService;
    
    @Resource
    private InvalidAuthenticationEntryPoint invalidAuthenticationEntryPoint;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                //禁用Basic验证
                .httpBasic().disable()
                //禁用CSRF
                .csrf().disable()
                //禁用默认登录页
                .formLogin().disable()
                //禁用默认登出
                .logout().disable()
                //前后端分离，禁用session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        authorizeHttpRequest -> authorizeHttpRequest
                                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                                //.requestMatchers("/api/supplier/list").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/authentication/login").permitAll()
                                .requestMatchers("/api/authentication/refreshToken").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/**").permitAll()
                                .requestMatchers("/error").permitAll()
                                
                                //登录后用户可访问任意URL
                                //.anyRequest().authenticated()
                                //鉴权
                                .anyRequest().access((authenticationSupplier, requestAuthorizationContext) -> {
                                    //获取当前用户权限
                                    Collection<? extends GrantedAuthority> authorities = authenticationSupplier.get().getAuthorities();
                                    HttpServletRequest request = requestAuthorizationContext.getRequest();
                                    String path = request.getRequestURI();
                                    List<String> roleNameList = roleService.getRoleNameByUrlPath(path);
                                    if(roleNameList == null || roleNameList.isEmpty()){
                                        return new AuthorizationDecision(false);
                                    }
                                    for(String roleName: roleNameList){
                                        for(GrantedAuthority grantedAuthority: authorities){
                                            if(grantedAuthority.getAuthority().equals(roleName)){
                                                return new AuthorizationDecision(true);
                                            }
                                        }
                                    }
                                    return new AuthorizationDecision(false);
                                })
                )
                .authenticationProvider(authenticationProvider())
                //在UsernamePasswordAuthenticationFilter添加Filter
                .addFilterBefore(JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                //异常处理
                .exceptionHandling().authenticationEntryPoint(invalidAuthenticationEntryPoint).accessDeniedHandler(aksAccessDeniedHandler);
                
        return httpSecurity.build();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(securityUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    
    @Bean
    public JwtOncePerRequestFilter JwtTokenFilter(){
        return new JwtOncePerRequestFilter();
    }
    
}
