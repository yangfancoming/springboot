package com.goat.utils;

import com.goat.jwt.JwtConfig;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;


@Component
public class JwtUtil {

    @Autowired public JwtConfig jwtConfig;
    /**
     *      Jwts.builder()
                     .setId("666") // 当前用户登录的 id
                     .setSubject("admin") // 当前用户登录的 用户名
                     .setIssuedAt(new Date()) // 当前用户登录的 登录时间

     admin  eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ2MDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.FnRqRgFQfrB8ibQ61mhk2mCAQF0-MrGerpM5ZxNJCJe4Mr9qsN6WbLKx-LJOU8gkRu_Ie3gQebJn9xLn33e2RQ
     goat  eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ4MjUsInVzZXJuYW1lIjoiZ29hdCJ9.OOB5uePQdRX4fedZCf9Ykn07q2C1HrcEdRmlFDQqRtOdAsg1PKWApSKA6OCn8QZ4awBm0Kq8F49XY_FkI3NQKw
    */
    // 生成 Token
    public String generateToken(String username,String tokenSigningKey) {
        //you can put any data in the map 可以自定义 键值对！
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("role", "guest");
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(map)  // 如果有 setClaims 则优先使用  如果没有 setClaims 才使用 setId setSubject setIssuedAt 。。。
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 设置token过期时间  1000 hour
                .signWith(SignatureAlgorithm.HS512, tokenSigningKey); // P1 加密算法  P2 加盐值
        String jwt = jwtBuilder.compact(); // 生成 jwt
        return "Bearer "+ jwt; //jwt前面一般都会加Bearer
    }

    // 验证 Token
    public  Claims validateToken(String token) {
          Claims claims = Jwts.parser() // 验证 使用  parser()
                .setSigningKey(jwtConfig.getTokenSigningKey())
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();
          return claims;
    }
}