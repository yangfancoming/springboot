package com.goat;

//import com.chen.common.constant.TopicConst;
//import com.chen.common.message.PayMessage;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * 类的功能描述：
 * 消息生产者用于发送消息
 * @ClassName: MessageProducer
 * @Author Goat
 * @Date 2019年1月16日13:56:38
 */
@Component
@EnableScheduling
public class MessageProducer {

    private static Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


   // 默认每3秒执行一次定时任务
    @Scheduled(fixedRate = 3*1000)
    public void send() {
        String s = UUID.randomUUID().toString();
        ListenableFuture send = kafkaTemplate.send("test", s);
        send.addCallback(o->System.out.println("producer生产者-----发送成功"+ s),Throwable->System.out.println("消息发送失败,"+s));
        logger.info("MessageProducer: send: message is: [" + "goatkdfksdfk1111111" + "]");
    }

}