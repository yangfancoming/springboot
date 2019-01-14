package com.goat;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 64274 on 2019/1/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/14---15:33
 */
public class CommonTest {

    public static final String QUEUE = "myChannel0";
    public static final String QUEUE1 = "myChannel1";
    public static final String QUEUE2 = "myChannel2";
    public final static String EXCHANGE_NAME = "fanout_exchange_test";

    public static Connection connection = null;
    public static Channel channel  = null;

    public static Channel init() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.163.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //        connectionFactory.setVirtualHost("/test"); // 设置虚拟主机
        connection = connectionFactory.newConnection(); // 获取连接
        channel = connection.createChannel();  // 创建通道
        /**
         声明队列： 如果队列存在 do nothing  如不存在则创建
         1. 队列名称
         2. 是否持久化队列：false则在内存中保存该队列 rabbitMQ重启后消失  true则保存erlang的数据库中  rabbitMQ重启后自动从数据库中读取
         3. 是否为独占式 ： true 则 其他通道不能访问该队列
         4. 是否自动删除：
         */
        channel.queueDeclare(QUEUE,false,false,false,null);
        return channel;
    }

    public static Channel init2() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.163.135");
//        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connection = connectionFactory.newConnection(); // 获取连接
        channel = connection.createChannel();  // 创建通道
        return channel;
    }
}
