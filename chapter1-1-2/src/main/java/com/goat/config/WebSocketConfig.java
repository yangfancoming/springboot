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
1.@Configuration：注解标识该类为Spring的配置类
2.@EnableWebSocket：开启注解接收和发送消息
 */
@Configuration
//@EnableWebSocket
@EnableWebSocketMessageBroker //开启 对 websocket支持
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /***
     * 注册 Stomp的端点 并映射到指定URL
     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
     * setAllowedOrigins("*")：  允许跨域访问
     * withSockJS：使用SockJS协议
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/v1/socket").setAllowedOrigins("*").withSockJS() ;
    }

    /**
     * 配置广播式消息代理
     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
     */
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/api/v1/socket/send");//推送消息前缀
        registry.setApplicationDestinationPrefixes("/api/v1/socket/req");//应用请求前缀
        registry.setUserDestinationPrefix("/user");//推送用户前缀
    }
}
