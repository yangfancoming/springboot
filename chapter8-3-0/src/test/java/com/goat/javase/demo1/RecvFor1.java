package com.goat.javase.demo1;

import com.goat.javase.common.CommomTest;
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
public class RecvFor1 extends CommomTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = init();
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8"); //  一旦进入该函数 那么 就接收消息确认
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE, true, consumer); // P2 是否自动确认消息消费
    }
}
