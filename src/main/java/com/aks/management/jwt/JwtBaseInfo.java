/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/24
 * Time: 16:21
 **/
package com.aks.management.jwt;

import lombok.Data;

@Data
public class JwtBaseInfo {
    
    private String username;
    private String[] roles;
    private String accessToken;
    private String refreshToken;
    private String expires;
    
}
