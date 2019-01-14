package com.goat.javase;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2019年1月14日13:53:47
*/

public class SendTestNg extends CommomTest {



    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("172.16.163.135");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
//        connectionFactory.setVirtualHost("/test"); // 设置虚拟主机
        Connection connection = connectionFactory.newConnection();// 获取连接
        Channel channel = connection.createChannel();  // 创建通道
        /**
         声明队列： 如果队列存在 do nothing  如不存在则创建
         1. 队列名称
         2. 是否持久化队列：false则在内存中保存该队列 rabbitMQ重启后消失  true则保存erlang的数据库中  rabbitMQ重启后自动从数据库中读取
         3. 是否为独占式 ： true 则 其他通道不能访问该队列
         4. 是否自动删除：
         */
        channel.queueDeclare(QUEUE,false,false,false,null);

        // 发送消息
        channel.basicPublish("",QUEUE,null,"发送消息内容".getBytes());
        // 关闭连接
        channel.close();
        connection.close();
    }


}
