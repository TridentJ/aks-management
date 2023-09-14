/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/12
 * Time: 22:52
 **/
package com.aks.management.security;

import com.aks.management.jwt.JwtUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    
    @Resource
    private SecurityUserDetailsService securityUserDetailsService;

    
    public Authentication getAuthentication(String token){
        String username = JwtUtil.getUsername(token);
        UserDetails userDetails = securityUserDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }
    
    public String getTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
    
    public boolean verifyToken(String token){
        DecodedJWT decodedJWT = JwtUtil.VerifyJwt(token);
        if(decodedJWT != null){
            return true;
        }
        return false;
    }
    

}
