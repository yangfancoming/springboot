package com.goat.config;

import com.goat.constants.RabbitConstants;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * Created by 64274 on 2018/9/29.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/29---14:59
 */

@Configuration
public class MyAMQPConfig {

    @Autowired
    private RabbitConstants rabbitConstants;

    /**
         * @Description:  使用自定义消息体序列化器  使用Json格式发送
         * @author: 杨帆
         * @Date:   2018/9/29
    */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitConstants.getHost());
        connectionFactory.setUsername(rabbitConstants.getUsername());
        connectionFactory.setVirtualHost(rabbitConstants.getVirtualHost());
        connectionFactory.setPassword(rabbitConstants.getPassword());
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(rabbitConstants.getPublisherConfirms());
        connectionFactory.setPublisherConfirms(rabbitConstants.getPublisherConfirms());
        return connectionFactory;
    }

    /**
     * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

}

