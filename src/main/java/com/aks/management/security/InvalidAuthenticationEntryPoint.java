/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/20
 * Time: 17:01
 **/
package com.aks.management.security;

import com.aks.management.utils.AjaxResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InvalidAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    @Resource
    private JwtProvider jwtProvider;
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String token = jwtProvider.getTokenFromRequest(request);
        //JwtInfo jwtInfo = new JwtInfo();
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(token == null){
            ajaxResponse.setCode(1010);
            ajaxResponse.setMessage("未认证");
        }else{
            ajaxResponse.setCode(1011);
            ajaxResponse.setMessage("认证信息已失效");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(ajaxResponse);
        
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
