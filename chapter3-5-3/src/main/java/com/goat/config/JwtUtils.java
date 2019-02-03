package com.goat.config;

//
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

public class JwtUtils {


    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5*60*1000;
	/**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的签发时间
     */
    public static Date getIssuedAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuedAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,expireTime 后过期
     * @param username 用户名
     * @param time 过期时间s
     * @return 加密的token
     */
    public static String sign(String username, String salt) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(salt);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * token 是否过期
     * @return true：过期
     */
    public static boolean isTokenExpired(String token) {
        Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }

    /**
     * 生成随机盐,长度32位
     * @return
     */
    public static String generateSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(16).toHex();
        return hex;
    }

}
