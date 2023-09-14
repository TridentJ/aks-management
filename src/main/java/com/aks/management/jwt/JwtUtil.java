/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/24
 * Time: 16:29
 **/
package com.aks.management.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    
    private static String SECRET_KEY = "Secret-Key-746464-aks-nj";
    
    
    public static TokenInfo generateAccessToken(Long id,String username){
        HashMap<String, Object> headers = new HashMap<>();
    
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.HOUR,6);
        
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setExpires(expires);
        tokenInfo.setToken(
                JWT.create()
                        .withHeader(headers)
                        .withClaim("userId",id)
                        .withClaim("username",username)
                        .withExpiresAt(expires.getTime())
                        .sign(Algorithm.HMAC256(SECRET_KEY))
        );
        
         return tokenInfo;
        
    }
    
    public static String generateRefreshToken(Long id,String username){
        HashMap<String, Object> headers = new HashMap<>();
        
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.HOUR,36);
    
        return JWT.create()
                .withHeader(headers)
                .withClaim("userId",id)
                .withClaim("username",username)
                .withExpiresAt(expires.getTime())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
    
    
    public static DecodedJWT VerifyJwt(String token){
        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
            
        }catch (JWTVerificationException e){
            return  null;
        }
        return decodedJWT;
    
    }
    
    
    public static String getUsername(String token){
        DecodedJWT decodedJWT = VerifyJwt(token);
        if(decodedJWT == null){
            return null;
        }
        return decodedJWT.getClaim("username").asString();
    }
    
    public static Long getUserId(String token){
        DecodedJWT decodedJWT = VerifyJwt(token);
        if(decodedJWT == null){
            return null;
        }
        return decodedJWT.getClaim("userId").asLong();
    }
    
    
    public static Map<String, Claim> getClaims(String token){
        DecodedJWT decodedJWT = VerifyJwt(token);
        if(decodedJWT == null){
            return null;
        }
        return decodedJWT.getClaims();
    }


}
