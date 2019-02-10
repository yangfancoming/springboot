package com.goat.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者类
 */
@Component
public class Consumer {

    @JmsListener(destination = "promoteAct")
    public void receiveQueue(String consumer) {
        System.out.println(consumer+"消息已经消费了");
    }

}
