package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by 64274 on 2018/8/24.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/24---2:56

 */
@Configuration
//@EnableWebSocket
@EnableWebSocketMessageBroker //开启 对 websocket支持
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/v1/socket").setAllowedOrigins("*").withSockJS() ;
    }


    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/api/v1/socket/send");//推送消息前缀
        registry.setApplicationDestinationPrefixes("/api/v1/socket/req");//应用请求前缀
        registry.setUserDestinationPrefix("/user");//推送用户前缀
    }
}
