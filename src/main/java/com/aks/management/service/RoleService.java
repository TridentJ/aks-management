/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/27
 * Time: 16:00
 **/
package com.aks.management.service;

import com.aks.management.bean.Role;
import com.aks.management.dao.RoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    
    @Resource
    private RoleMapper roleMapper;
    
    /**
     * 根据URL查询，哪些角色具有访问该URL的权限
     * 例如URL为/api/test/add，则需要查询三类
     * 1. /api/test/add
     * 2. /api/test/*
     * 3. /api/*
     *
     * */
    public List<String> getRoleNameByUrlPath(String urlPath){
        
        //List<String> roleList  = new ArrayList<>();
        String trimUrlPath = null;
        if(urlPath == null || !urlPath.contains("/") || !urlPath.startsWith("/")){
            return null;
        }
        if(urlPath.endsWith("/")){
            trimUrlPath = urlPath.substring(0,urlPath.length()-1);
        }else{
            trimUrlPath = urlPath;
        }
        String[] pathList = trimUrlPath.split("/");
        
        List<Role> roleList =  new ArrayList<>();
        Set<String> roleSetStr = new HashSet<>();
        
        //类型1 /api/test/add
        roleList = roleMapper.selectByPermissionTableUrlPath(trimUrlPath);
        if(roleList != null){
            roleList.forEach( role -> {
                roleSetStr.add(role.getRoleName());
            });
            roleList.clear();
        }
        //类型2 /api/test/*
        pathList[pathList.length - 1] = "*";
        String newUrlPath = String.join("/",pathList);
        roleList = roleMapper.selectByPermissionTableUrlPath(newUrlPath);
        if(roleList != null){
            roleList.forEach(role -> {
                roleSetStr.add(role.getRoleName());
            });
            roleList.clear();
        }
        
        //类型3 /api/*
        newUrlPath = "/" + pathList[1] + "/*";
        //System.out.println("newUrlPath:" + newUrlPath);
        roleList = roleMapper.selectByPermissionTableUrlPath(newUrlPath);
        if(roleList != null){
            roleList.forEach(role -> {
                roleSetStr.add(role.getRoleName());
            });
            roleList.clear();
        }
        if(roleSetStr.isEmpty()){
            return null;
        }else{
            /*
            System.out.print("Url role:");
            roleSetStr.forEach(role -> {
                System.out.println(role);
            });
            */
            return new ArrayList<>(roleSetStr);
        }
    }
    
    public List<String> getRoleNameByUserId(Long id){
        List<Role> roleList = roleMapper.selectRoleNameByUserId(id);
        if(roleList == null || roleList.isEmpty()){
            return null;
        }
        Set<String> roleSetStr = new HashSet<>();
        roleList.forEach( role -> {
            roleSetStr.add(role.getRoleName());
        });
        return  new ArrayList<>(roleSetStr);
    }
    
}
