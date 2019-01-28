package com.goat.producer;

import com.goat.constants.RabbitConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 64274 on 2019/1/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/28---13:32
 */
@Component
public class DemoSender implements RabbitTemplate.ConfirmCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public DemoSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

    public void send(String msg) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString().replace("-",""));
        System.out.println("send: " + correlationData.getId());
//        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE, RabbitConstants.ROUTINGKEY, msg, correlationData);
//        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE,"", msg, correlationData);
        rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGE,"", msg,correlationData);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("confirm: " + correlationData.getId());
        System.out.println("ack: " + ack);
        System.out.println("cause: " + cause);
    }
}
