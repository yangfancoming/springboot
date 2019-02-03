package com.goat.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.goat.dto.UserDto;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class JwtCredentialsMatcher implements CredentialsMatcher {
	
	private final Logger log = LoggerFactory.getLogger(JwtCredentialsMatcher.class);
    /**
     * Matcher中直接调用工具包中的verify方法即可
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        System.out.println("进入 JwtCredentialsMatcher---doCredentialsMatch() 匹配操作。。。。。。。。。。。。。。");
        String token = (String) authenticationToken.getCredentials();
        String salt = authenticationInfo.getCredentials().toString();
        UserDto user = (UserDto)authenticationInfo.getPrincipals().getPrimaryPrincipal();
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(salt))
                    .withClaim("username", user.getUsername())
                    .build();
            verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException | JWTVerificationException e) {
            log.error("Token Error:{}", e.getMessage());
        }
        return false;
    }

}
