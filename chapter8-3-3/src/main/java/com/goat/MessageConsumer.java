package com.goat;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    // doit 为什么 两个方法同时存在 就只走该方法 ？
    @KafkaListener(topics = {"test"}, groupId = "test")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("【1】record =" + record);
            logger.info("【1】message =" + message);
            logger.info("【1】" + record.key());
        }
    }
}