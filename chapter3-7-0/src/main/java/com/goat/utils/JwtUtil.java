package com.goat.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    static final String SECRET = "ThisIsASecret";

    // admin  eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ2MDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.FnRqRgFQfrB8ibQ61mhk2mCAQF0-MrGerpM5ZxNJCJe4Mr9qsN6WbLKx-LJOU8gkRu_Ie3gQebJn9xLn33e2RQ
    // goat  eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ4MjUsInVzZXJuYW1lIjoiZ29hdCJ9.OOB5uePQdRX4fedZCf9Ykn07q2C1HrcEdRmlFDQqRtOdAsg1PKWApSKA6OCn8QZ4awBm0Kq8F49XY_FkI3NQKw
    // 生成 Token
    public static String generateToken(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username); //you can put any data in the map
        map.put("role", "guest"); //  可以自定义 键值对！
        JwtBuilder jwtBuilder = Jwts.builder() // 生成使用  builder()
//                .setId("666") // 当前用户登录的 id
//                .setSubject("admin") // 当前用户登录的 用户名
//                .setIssuedAt(new Date()) // 当前用户登录的 登录时间
                .setClaims(map)  // 如果有 setClaims 则优先使用  如果没有 setClaims 才使用 setId setSubject setIssuedAt 。。。
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 设置token过期时间  1000 hour
                .signWith(SignatureAlgorithm.HS512, SECRET); // P1 加密算法  P2 加盐值
//                .claim("role","guest");
        String jwt = jwtBuilder.compact(); // 生成 jwt
        return "Bearer "+ jwt; //jwt前面一般都会加Bearer
    }


    // 验证 Token
    public static Claims validateToken(String token) {
//        Map<String, Object> body = Jwts.parser() // 验证 使用  parser()
          Claims claims = Jwts.parser() // 验证 使用  parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();
          return claims;
    }
}