package com.goat;


import com.goat.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Mytest {


    @Test
    public void generateToken()   {
        String admin = JwtUtil.generateToken("g123");
        System.out.println(admin);
    }

    // goat  eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ4MjUsInVzZXJuYW1lIjoiZ29hdCJ9.OOB5uePQdRX4fedZCf9Ykn07q2C1HrcEdRmlFDQqRtOdAsg1PKWApSKA6OCn8QZ4awBm0Kq8F49XY_FkI3NQKw
    @Test
    public void validateToken()   {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NDk1NjQ4MjUsInVzZXJuYW1lIjoiZ29hdCJ9.OOB5uePQdRX4fedZCf9Ykn07q2C1HrcEdRmlFDQqRtOdAsg1PKWApSKA6OCn8QZ4awBm0Kq8F49XY_FkI3NQKw";
        Claims claims = JwtUtil.validateToken(token);
        System.out.println(claims);
    }
}
