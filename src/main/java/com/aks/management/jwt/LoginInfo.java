/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/24
 * Time: 16:26
 **/
package com.aks.management.jwt;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="用户登录类",description = "用户登录所使用的的信息")
public class LoginInfo {
    
    @Schema(type="String", description = "用户名")
    private String username;
    @Schema(type = "String", description = "密码,SHA-256后的值")
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
