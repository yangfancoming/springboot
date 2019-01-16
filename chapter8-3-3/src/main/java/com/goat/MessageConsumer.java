package com.goat;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 类的功能描述：
 * 消息消费者者用于处理消息
 * @ClassName: MessageConsumer
 * @Author 杨帆
 * @Date 2019年1月16日13:56:47
 */
@Service
public class MessageConsumer {
    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "test")
    public void onMessage(String payMessage) {
        logger.info("MessageConsumer: onMessage: message is: [" + payMessage + "]");
    }
}