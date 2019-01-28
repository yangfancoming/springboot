package com.goat.controller;

import com.goat.constants.RabbitConstants;
//import com.goat.producer.DemoSender;
import com.goat.producer.DemoSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 64274 on 2019/1/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/28---13:45
 */
@RestController
@RequestMapping("demo")
public class DemoController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DemoSender demoSender;
//    http://localhost:8831/demo/amqp

    @RequestMapping("amqp")
    public void amqp(){
        rabbitTemplate.convertAndSend(RabbitConstants.QUEUE,"1message from web");
    }

    @RequestMapping("amqp1")
    public void amqp1(){
        rabbitTemplate.convertAndSend("exchange","topic.messages","2message from web for exchage");
    }

    @RequestMapping("amqp2")
    public void amqp2(){
        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE,RabbitConstants.ROUTINGKEY,"3message from web for fanoutExchange");
    }

    @RequestMapping("amqp3")
    public void amqp3(){ //主要是下面这个
        demoSender.send("message from web for fanoutExchange1234234");
    }

    @RequestMapping("amqp4")
    public void amqp4(){
        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE,"","3message from web for fanoutExchange");
    }
}
