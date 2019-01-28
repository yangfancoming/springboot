package com.goat.simple.demo1;

import com.goat.CommonTest;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 64274 on 2019/1/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/14---17:45
 */
public class RecvFor2 extends CommonTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = init();
        //回调消费消息 doit 录个视频
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                System.out.println("haha" + 1/0);
                channel.basicAck(envelope.getDeliveryTag(),false); // 只有手动确认后  才算消息已接收！
            }
        };
        channel.basicConsume(QUEUE, false, consumer);
    }
}
