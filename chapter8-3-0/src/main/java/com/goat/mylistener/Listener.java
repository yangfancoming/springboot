package com.goat.mylistener;

import com.goat.constants.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by 64274 on 2019/1/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/28---13:46
 */
@Configuration
public class Listener {

    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(RabbitConstants.EXCHANGE);
    }

    @Bean
    public Queue fooQueue() {
        return new Queue(RabbitConstants.QUEUE);
    }

    @Bean
    public Binding binding() {
        /** 将队列绑定到交换机 */
        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(RabbitConstants.ROUTINGKEY);
    }

    /** 项目启动后，后台一直循环报错 Caused by: org.springframework.amqp.AmqpException: No method found for class [B
        解决方法：@RabbitListener(queues = RabbitConstants.QUEUE) 要放在方法上 不能放在类上
    */
    @RabbitListener(queues = RabbitConstants.QUEUE)
    public void process(@Payload String foo) {
        System.out.println("Listener: " + foo);
    }
}
