package com.goat.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2018/9/29.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/29---14:59
 */

@Configuration
public class MyAMQPConfig{


    /**
         * @Description:  使用自定义消息体序列化器  使用Json格式发送
         * @author: 杨帆
         * @Date:   2018/9/29
    */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

