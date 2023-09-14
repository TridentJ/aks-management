/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/13
 * Time: 15:36
 **/
package com.aks.management.security;

import com.aks.management.bean.User;
import com.aks.management.service.RoleService;
import com.aks.management.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityUserDetailsService implements UserDetailsService {
    
    @Resource
    private UserService userService;
    
    @Resource
    private RoleService roleService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        User user = null;
        try {
            user = userService.getUserByUsername(username);
            if(user == null){
                throw new UsernameNotFoundException("用户不存在");
            }
            //authorityList.add(new SimpleGrantedAuthority(user.getRoleList()));
            List<String> roleNameList = roleService.getRoleNameByUserId(user.getId());
            if(roleNameList == null || roleNameList.isEmpty()){
                //System.out.print("user role:");
                authorityList.add(new SimpleGrantedAuthority("null"));
            }else{
                System.out.print("user role:");
                roleNameList.forEach( roleName -> {
                    System.out.println(roleName);
                    authorityList.add(new SimpleGrantedAuthority(roleName));
                });
            }
            
        }catch (Exception e){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new SecurityUserDetails(user.getUsername(),user.getPassword(),authorityList,true,true,true,true);
        
    }
}
