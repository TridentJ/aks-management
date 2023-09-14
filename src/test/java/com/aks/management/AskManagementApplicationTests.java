package com.aks.management;

import com.github.yitter.idgen.YitIdHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@SpringBootTest
class AskManagementApplicationTests {
    
    @Test
    void contextLoads() {
    }
    
    @Test
    void getYitId(){
        System.out.println(YitIdHelper.nextId());
    }
    
    @Test
    void getBcryptPassword(){
        long newId = YitIdHelper.nextId();
        System.out.println(newId);
        //SecureRandom secureRandom = new SecureRandom();
        //System.out.println(random);
        StringBuilder hexString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update("admin1234".getBytes("UTF-8"));
            byte[] result = messageDigest.digest();
            hexString = new StringBuilder();
            for (byte b : result) {
                hexString.append(String.format("%02X", b));
            }
            System.out.println("hexString:" + hexString);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bpassword = bCryptPasswordEncoder.encode(hexString);
        System.out.println(bpassword);
        /*
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(bpassword,"937E8D5FBB48BD4949536CD65B8D35C426B80D2F830C5C308E2CDEC422AE2244")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        */
    }
    
    
}
