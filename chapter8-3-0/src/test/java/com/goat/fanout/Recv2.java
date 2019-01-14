package com.goat.fanout;

import com.goat.CommonTest;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

// 消费者2
public class Recv2 extends CommonTest {


    public static void main(String[] argv) throws Exception {
        Channel channel = init2();
        channel.queueDeclare(QUEUE2,false,false,false,null);
        channel.queueBind(QUEUE2, EXCHANGE_NAME, "");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,byte[] body) {
                String msg = new String(body);  // body 即消息体
                System.out.println(" [消费者2] received : " + msg + "!");
            }
        };
        channel.basicConsume(QUEUE2, true, consumer);
    }
}