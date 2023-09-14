/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/24
 * Time: 16:49
 **/
package com.aks.management.jwt;

public class JwtRefreshInfo {
    
    private String accessToken;
    private String refreshToken;
    private String expires;
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getRefreshToken() {
        return refreshToken;
    }
    
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    
    public String getExpires() {
        return expires;
    }
    
    public void setExpires(String expires) {
        this.expires = expires;
    }
}
