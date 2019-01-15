package com.goat.controller;

/**
 * Created by 64274 on 2019/1/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/15---22:27
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试kafka生产者
 */
@RestController
@RequestMapping("kafka")
public class TestKafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        kafkaTemplate.send("test_topic", msg);
        return "success";
    }

}
