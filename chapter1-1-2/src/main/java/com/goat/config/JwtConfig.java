package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Return:
     * @Date:   2018/7/14
 *     @PropertySource( value= {"classpath:security.yaml"}) // sos  @PropertySource 该注解不支持 yaml文件 只支持 properties文件！！！
*/
@PropertySource( value= {"classpath:security.properties"})
@Configuration
@ConfigurationProperties(prefix = "security")
public class JwtConfig {
    /**
     * Token issuer.
     */
    private Integer tokenExpirationTime;
    private String tokenIssuer;
    private String tokenSigningKey;
    private Integer refreshTokenExpTime;
    
    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }
    
    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }
    
    public String getTokenIssuer() {
        return tokenIssuer;
    }
    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }
    
    public String getTokenSigningKey() {
        return tokenSigningKey;
    }
    
    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
