package com.goat.controller;

import com.goat.entity.Account;
import com.goat.jwt.JwtConfig;
import com.goat.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2018/11/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/20---15:09
 */

@RestController
public class TestController {

    @Autowired JwtUtil jwtUtil;

    // http://localhost:8370/api/protected
    @GetMapping("/api/protected")
    public Object hellWorld() {
        return "Hello World! This is a protected api";
    }

    // http://localhost:8370/  前天 login 登录按钮 请求方法
    @PostMapping("/login")
    public Object login(@RequestBody final Account account) {

        if(account.getUsername().equals("admin") && account.getPassword().equals("123")){
            String jwt = jwtUtil.generateToken(account.username,"ThisIsASecret");
            return new HashMap<String,String>(){{
                put("token", jwt);
            }};
        }else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    // http://localhost:8370/test1
    @GetMapping("/test1")
    public String test1()   {
        String admin = jwtUtil.generateToken("haha","xm8EV6Hy5RMFK4EEACIDAwQus");
        System.out.println(admin);
        return admin;
    }

    // http://localhost:8370/test2?token=eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiZ3Vlc3QiLCJleHAiOjE1NTE4OTQzNzIsInVzZXJuYW1lIjoiaGFoYSJ9.cAlZu9VcRbIXjDCK3bCoW3fQDEwM5uW57t8yx4XqN0RUxAI8FJs0xseWi9DSs9CnXTRrej649R9mJppDNJBuvA
    @GetMapping("/test2")
    public Map test2(String token)   {
        Claims claims = jwtUtil.validateToken(token);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(claims);
        return claims;
    }

    @Autowired
    public JwtConfig jwtConfig;
    // http://localhost:8370/test3  测试 token 过期时间
    @GetMapping("/test3")
    public void test3()   {
        System.out.println(jwtConfig.getTokenExpirationTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() + jwtConfig.getTokenExpirationTime());
        System.out.println(System.currentTimeMillis() + 5 * 60 * 1000);
        System.out.println(System.currentTimeMillis() + 3600000000L);
        System.out.println(System.currentTimeMillis() + 3600_000_000L);
    }
}
