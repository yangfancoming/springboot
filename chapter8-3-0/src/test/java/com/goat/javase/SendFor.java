package com.goat.javase;

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
public class SendFor extends CommomTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = init();
        for (int i = 0; i < 50; i++) {
            channel.basicPublish("",QUEUE,null,("content" + i).getBytes());
        }
        // 关闭连接
        channel.close();
        connection.close();
    }
}
