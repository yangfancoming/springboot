package com.goat.direct;

import com.goat.CommonTest;
import com.rabbitmq.client.Channel;

public class Send extends CommonTest {

    public static void main(String[] argv) throws Exception {
        Channel channel = init();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");
        // 消息内容
        String message = "商品新增了， id = 1001";
        // 发布消息到Exchange
//        channel.basicPublish(DIRECT_EXCHANGE_NAME, "insert", null, message.getBytes()); // 只有 recv1 可以接收到
        channel.basicPublish(DIRECT_EXCHANGE_NAME, "update", null, message.getBytes()); //  recv1 和 recv2 都可以接收到
        System.out.println(" [商品服务：] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}