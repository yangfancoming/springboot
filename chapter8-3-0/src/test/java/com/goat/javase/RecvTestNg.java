package com.goat.javase;

import com.rabbitmq.client.*;

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


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.163.135");
//        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
//        connectionFactory.setVirtualHost("/test"); // 设置虚拟主机
        Connection connection = connectionFactory.newConnection(); // 获取连接
        Channel channel = connection.createChannel();  // 创建通道
        /**
         声明队列： 如果队列存在 do nothing  如不存在则创建
         1. 队列名称
         2. 是否持久化队列：false则在内存中保存该队列 rabbitMQ重启后消失  true则保存erlang的数据库中  rabbitMQ重启后自动从数据库中读取
         3. 是否为独占式 ： true 则 其他通道不能访问该队列
         4. 是否自动删除：
         */
        channel.queueDeclare(QUEUE,false,false,false,null);

        //回调消费消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE, true, consumer);
    }
}
