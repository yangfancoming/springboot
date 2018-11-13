package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/12---20:16
 *
wechat.appid=wx6db2e6dfef75ccf4
wechat.appsecret=7f6be395036eac000d5840b09bfde523
wechat.token=123
wechat.aesKey=
 */

@Configuration
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private  String appid;
    private  String appsecret;
    private  String returnUrl;
    private  String token;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return appsecret;
    }

    public void setSecret(String secret) {
        this.appsecret = secret;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
