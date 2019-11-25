package com.goat.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/11/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/25---16:46
 */

@Configuration
//控制Configuration是否生效
@ConditionalOnProperty(name = "spring.kafka.gourd.enabled", havingValue = "true")
public class KafkaConsumerConfig {

    public void test(){
        System.out.println("hello kafka");
    }
}

