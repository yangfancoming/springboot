package com.goat.chapter277.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2020/3/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/19---13:41
 */
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false,prefix = "baidu")
public class TranslateProperties extends BaseResult {

    private String q;
    private String appid;
    private String salt;
    private String sign;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
