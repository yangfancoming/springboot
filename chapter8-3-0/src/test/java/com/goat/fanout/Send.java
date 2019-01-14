package com.goat.fanout;

import com.goat.CommonTest;
import com.rabbitmq.client.Channel;

public class Send extends CommonTest {

    public static void main(String[] argv) throws Exception {
        Channel channel = init();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 消息内容
        String message = "Hello everyone fanout1111 ";
        // 发布消息到Exchange
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [生产者] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}