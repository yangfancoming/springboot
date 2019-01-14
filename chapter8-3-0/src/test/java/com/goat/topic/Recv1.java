package com.goat.topic;

import com.goat.CommonTest;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 消费者2
 */
public class Recv1 extends CommonTest {

    public static void main(String[] argv) throws Exception {

        Channel channel = init2();
        // 声明队列
        channel.queueDeclare(QUEUE1, false, false, false, null);
        // 绑定队列到交换机，同时指定需要订阅的routing key。需要 update、delete
        channel.queueBind(QUEUE1, TOPIC_EXCHANGE_NAME, "item.update");
        channel.queueBind(QUEUE1, TOPIC_EXCHANGE_NAME, "item.delete");
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,byte[] body) {
                String msg = new String(body);// body 即消息体
                System.out.println(" [消费者1] received : " + msg + "!");
            }
        };
        // 监听队列，自动ACK
        channel.basicConsume(QUEUE1, true, consumer);
    }
}