package com.goat.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 生产者类
 */
@Component
public class Producer {

    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 2000)    // 每2s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hello,activeMQ");
    }

}

