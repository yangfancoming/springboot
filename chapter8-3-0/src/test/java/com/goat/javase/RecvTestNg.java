package com.goat.javase;

import com.rabbitmq.client.*;
import org.junit.Test;
//import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 64274 on 2019/1/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/14---14:53
 */


public class RecvTestNg extends CommomTest {

    @Test
    public void recv1() throws IOException, TimeoutException {
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


    @Test
    public void recv2() throws IOException, TimeoutException {
        Channel channel = init();
        //回调消费消息 doit 录个视频
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                System.out.println("haha" + 1/0);
                channel.basicAck(envelope.getDeliveryTag(),false); // 只有手动消息确认后  才算消息已接收！
            }
        };
        channel.basicConsume(QUEUE, false, consumer);
    }
}
