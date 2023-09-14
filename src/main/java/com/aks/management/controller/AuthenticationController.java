/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/24
 * Time: 16:25
 **/
package com.aks.management.controller;

import com.aks.management.bean.User;
import com.aks.management.jwt.*;
import com.aks.management.service.RoleService;
import com.aks.management.service.UserService;
import com.aks.management.utils.AjaxResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@Tag(name="鉴权接口",description = "鉴权接口信息")
@RequestMapping(value="/api/authentication")
public class AuthenticationController {
    
    
    @Resource
    private UserService userService;
    
    @Resource
    private RoleService roleService;
    
    //json格式入参
    @Operation(summary = "登录接口",description = "通过用户名/密码登录")
    @Parameter(name = "loginInfo",description = "用户名和密码",required = true)
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public AjaxResponse login(@RequestBody LoginInfo loginInfo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();
        if(username == null || password == null){
            ajaxResponse.setCode(1101);
            ajaxResponse.setMessage("用户名或密码不能为空");
            return ajaxResponse;
        }
        password = password.toUpperCase();
        System.out.println("password:" + password);
        User user = null;
        //直接校验
        try {
            user = userService.getUserByUsername(username);
            if(user == null){
                throw new RuntimeException();
            }
            //计算SHA-256
            /*
            StringBuilder hexString = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password.getBytes("UTF-8"));
                byte[] result = messageDigest.digest();
                hexString = new StringBuilder();
                for (byte b : result) {
                    hexString.append(String.format("%02X", b));
                }
                //System.out.println("hexString:" + hexString);
                password = String.valueOf(hexString);
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                jwtInfo.setCode(1103);
                jwtInfo.setMessage("SHA-256出错");
                return jwtInfo;
            }
            */
            
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(!passwordEncoder.matches(password,user.getPassword())){
                ajaxResponse.setCode(1102);
                ajaxResponse.setMessage("用户名或密码错误");
                return ajaxResponse;
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResponse.setCode(1103);
            ajaxResponse.setMessage("用户不存在");
            return ajaxResponse;
        }
        
        //认证成功
        JwtBaseInfo jwtBaseInfo = new JwtBaseInfo();
        TokenInfo tokenInfo = JwtUtil.generateAccessToken(user.getId(),user.getUsername());
        jwtBaseInfo.setAccessToken(tokenInfo.getToken());
        jwtBaseInfo.setRefreshToken(JwtUtil.generateRefreshToken(user.getId(),user.getUsername()));
        jwtBaseInfo.setUsername(username);
        List<String> roleList = roleService.getRoleNameByUserId(user.getId());
        if(roleList == null || roleList.isEmpty()){
            jwtBaseInfo.setRoles(new String[]{});
        }else{
            jwtBaseInfo.setRoles(roleList.toArray(new String[roleList.size()]));
        }
        //jwtBaseInfo.setRoles(new String[]{"admin"});
        //Calendar expires = Calendar.getInstance();
        //expires字段时间应和accessToken中expires相同
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        jwtBaseInfo.setExpires(sdf.format(tokenInfo.getExpires().getTime()));
    
    
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("success");
        ajaxResponse.setData(jwtBaseInfo);
        
        return ajaxResponse;
    }
    
    
    @RequestMapping(value="/refreshToken",method = RequestMethod.POST)
    public AjaxResponse getRefreshToken(@RequestBody String refreshToken){
        //JwtInfo jwtInfo = new JwtInfo();
        AjaxResponse ajaxResponse = new AjaxResponse();
        String username = JwtUtil.getUsername(refreshToken);
        if(username == null){
            //refreshToken验证未通过，或不存在
            ajaxResponse.setCode(1011);
            ajaxResponse.setMessage("认证信息已失效");
            return ajaxResponse;
        }
        Long userId = JwtUtil.getUserId(refreshToken);
        if(userId == null || userId < 1L){
            //userId不存在
            ajaxResponse.setCode(1011);
            ajaxResponse.setMessage("认证信息已失效");
            return ajaxResponse;
        }
        JwtRefreshInfo jwtRefreshInfo = new JwtRefreshInfo();
        TokenInfo tokenInfo = JwtUtil.generateAccessToken(userId,username);
        jwtRefreshInfo.setAccessToken(tokenInfo.getToken());
        //jwtRefreshInfo.setRefreshToken(JwtUtil.generateRefreshToken(userId,username));
        jwtRefreshInfo.setRefreshToken(refreshToken);
        //Calendar expires = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        jwtRefreshInfo.setExpires(sdf.format(tokenInfo.getExpires().getTime()));
    
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("success");
        ajaxResponse.setData(jwtRefreshInfo);
        
        return ajaxResponse;
    }
    
    
}
