/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/25
 * Time: 20:21
 **/
package com.aks.management.jwt;

import java.util.Calendar;

public class TokenInfo {
    
    private String token;
    private Calendar expires;
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public Calendar getExpires() {
        return expires;
    }
    
    public void setExpires(Calendar expires) {
        this.expires = expires;
    }
}
