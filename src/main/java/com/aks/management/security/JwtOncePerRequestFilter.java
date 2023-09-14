/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/12
 * Time: 22:51
 **/
package com.aks.management.security;

import com.aks.management.utils.AjaxResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtOncePerRequestFilter extends OncePerRequestFilter {
    
    @Resource
    private JwtProvider jwtProvider;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.getTokenFromRequest(request);
        //AjaxResponse ajaxResponse = new AjaxResponse();
        //int errorFlag = 0;
        if(token != null){
            if(jwtProvider.verifyToken(token)){
                Authentication authentication = jwtProvider.getAuthentication(token);
                if(authentication != null){
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
