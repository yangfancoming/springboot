package com.goat.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义队列和topic的类

 */
@Configuration
public class QueueDefine {
    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("promoteAct");
    }
}
