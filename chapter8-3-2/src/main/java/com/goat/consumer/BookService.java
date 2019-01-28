package com.goat.consumer;

import com.goat.constants.RabbitConstants;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by 64274 on 2018/9/29.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/29---15:25
 *
 *  启动该项目后， 使用test 方法  发送广播消息， 一旦监听到消息队列中有消息发来 那么就触发该方法
 *  打印：收到消息队列中的来了新的消息---Book{bookName='西游记', author='陆小曼'}
 */

@Service
public class BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

//    @RabbitListener(queues = RabbitConstants.QUEUE2) //queues 指定要监听 哪个消息队列
//    public void receive2(Message message){
//        System.out.println("收到消息队列中的来了新的消息---" );
//        System.out.println(message.getBody());
//        System.out.println(message.getMessageProperties());
//        System.out.println(message.getClass());
//    }

    /**
     @Queue 要绑定的队列
     @Exchange  要绑定的交换器
     type  交换器类型
     key   路由key
     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = RabbitConstants.QUEUE3, durable = "true"),
//            exchange = @Exchange(value = RabbitConstants.EXCHANGE,ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
//            key = {"item.insert","item.update"}))
//    public void topic(String msg){
//        System.out.println("接收到消息：" + msg);
//    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConstants.QUEUE1, durable = "false"),
            exchange = @Exchange(value = RabbitConstants.EXCHANGE,ignoreDeclarationExceptions = "true",type = ExchangeTypes.FANOUT)))
    public void fanout(Message msg, Channel channel) throws IOException, InterruptedException {
//        Thread.sleep(5000);
        System.out.println("接收到消息：" + msg);
        // 监听队列，手动返回完成
//        channel.basicConsume(RabbitConstants.QUEUE1, false, null);
        //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);

        //ack返回false，并重新回到队列，api里面解释得很清楚
//        channel.basicNack(msg.getMessageProperties().getDeliveryTag(), false, true);

        //拒绝消息
//        channel.basicReject(msg.getMessageProperties().getDeliveryTag(), true);
        System.out.println(new String(msg.getBody()));
//        throw new  RuntimeException();
    }


}
