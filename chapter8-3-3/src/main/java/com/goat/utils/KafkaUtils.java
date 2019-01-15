package com.goat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


/**
 * Created by 64274 on 2019/1/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/15---20:56
 */
@Component
public class KafkaUtils {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic,String key,String message) {
        this.kafkaTemplate.send(topic,key,message);
    }
}

