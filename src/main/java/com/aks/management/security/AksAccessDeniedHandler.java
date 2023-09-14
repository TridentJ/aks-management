/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/27
 * Time: 15:53
 **/
package com.aks.management.security;

import com.aks.management.utils.AjaxResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AksAccessDeniedHandler implements AccessDeniedHandler {
    
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //JwtInfo jwtInfo = new JwtInfo();
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(1012);
        ajaxResponse.setMessage("无权限");
    
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(ajaxResponse);
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.getWriter().write(result);
    }
}
