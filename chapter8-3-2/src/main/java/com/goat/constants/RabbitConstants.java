package com.goat.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/1/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/28---13:26
 */
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitConstants {

    public static final String EXCHANGE   = "goat1111111";
    public static final String ROUTINGKEY = "routingkey";
    public static final String QUEUE      = "bootQueue";
    public static final String QUEUE1     = "myChannel1";
    public static final String QUEUE2     = "myChannel2";
    public static final String QUEUE3     = "myChannel3";

    private String host;

    private Integer port;

    private String username;

    private String password;

    private Boolean publisherConfirms;

    private String virtualHost;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
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

    public Boolean getPublisherConfirms() {
        return publisherConfirms;
    }

    public void setPublisherConfirms(Boolean publisherConfirms) {
        this.publisherConfirms = publisherConfirms;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }
}
