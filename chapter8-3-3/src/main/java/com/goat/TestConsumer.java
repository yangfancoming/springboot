package com.goat;

/**
 * Created by 64274 on 2019/1/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/15---22:27
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者测试
 */
@Component
public class TestConsumer {

    @KafkaListener(topics = "test_topic")
    public void listen (ConsumerRecord<?, ?> record)   {
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
