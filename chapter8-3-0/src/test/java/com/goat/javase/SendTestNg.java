package com.goat.javase;


import com.goat.javase.common.CommomTest;
import com.rabbitmq.client.Channel;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Date:   2019年1月14日13:53:47
*/

public class SendTestNg extends CommomTest {


    // 发送 单条 消息
    @Test
    public void send1() throws IOException, TimeoutException {
        Channel channel = init();
        // 发送消息
        channel.basicPublish("",QUEUE,null,"发送消息内容111".getBytes());
        // 关闭连接
        channel.close();
        connection.close();
    }

    // 发送 多条 消息
    @Test
    public void sendFor() throws IOException, TimeoutException {
        Channel channel = init();
        for (int i = 0; i < 50; i++) {
            channel.basicPublish("",QUEUE,null,("content" + i).getBytes());
        }
        // 关闭连接
        channel.close();
        connection.close();
    }

}
