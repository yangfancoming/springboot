package com.goat;


import com.goat.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;

import java.text.SimpleDateFormat;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Mytest {


    @Test
    public void generateToken()   {
        String admin = JwtUtil.generateToken("haha","ThisIsASecret");
        System.out.println(admin);
    }

    // eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiZ3Vlc3QiLCJleHAiOjE1NDk1NjYyMDMsInVzZXJuYW1lIjoiaGFoYSJ9.Ux6LStOLZPh3H4-SImXdqjB8CKy7GTLMjY4DyRpfqletGO9cqDghYUsGAfKvlLycenAJBjJrs9llHqpjK1TMuw
    @Test
    public void validateToken()   {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiZ3Vlc3QiLCJleHAiOjE1NDk1NjYyMDMsInVzZXJuYW1lIjoiaGFoYSJ9.Ux6LStOLZPh3H4-SImXdqjB8CKy7GTLMjY4DyRpfqletGO9cqDghYUsGAfKvlLycenAJBjJrs9llHqpjK1TMuw";
        Claims claims = JwtUtil.validateToken(token);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(claims);
    }
}
