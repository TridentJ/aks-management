/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/5/12
 * Time: 23:25
 **/
package com.aks.management.service;

import com.aks.management.bean.User;
import com.aks.management.bean.UserExample;
import com.aks.management.dao.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Resource
    private UserMapper userMapper;
    
    public User getUserByUsername(String username){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList == null || userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }
    
    
}
