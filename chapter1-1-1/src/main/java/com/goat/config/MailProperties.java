package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by 64274 on 2019/1/23.
 * @ author  山羊来了
 * @ date 2019/1/23---11:26
 * @ConfigurationProperties 告诉Springboot 将本类中的所有属性和配置文件中的相关配置记性绑定
 * ignoreUnknownFields = false告诉Spring Boot 在有属性不能匹配到声明的域的时候抛出异常
 * prefix 用来选择哪个属性的prefix名字来绑定
 */
@Configuration // 如果不加该注解 报错：Field mailProperties in com.goat.controller.TestControler required a bean of type 'com.goat.config.MailProperties' that could not be found.
@ConfigurationProperties(ignoreUnknownFields = false,prefix = "mail")
public class MailProperties {

    @NotBlank
    private String host;
    private int port;
    private String from;
    private String username;
    private String password;
    @NotNull
    private Smtp smtp;

    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnable;

        public boolean isAuth() {
            return auth;
        }

        public void setAuth(boolean auth) {
            this.auth = auth;
        }

        public boolean isStarttlsEnable() {
            return starttlsEnable;
        }

        public void setStarttlsEnable(boolean starttlsEnable) {
            this.starttlsEnable = starttlsEnable;
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Smtp getSmtp() {
        return smtp;
    }

    public void setSmtp(Smtp smtp) {
        this.smtp = smtp;
    }
}