package com.goat.mylistener;

import com.goat.constants.RabbitConstants;
import com.goat.chapter001.entity.Book;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

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

    @RabbitListener(queues = RabbitConstants.QUEUE1) //queues 指定要监听 哪个消息队列
    public void receive(Book book){
        System.out.println("收到消息队列中的来了新的消息---" + book);
    }

    @RabbitListener(queues = RabbitConstants.QUEUE2) //queues 指定要监听 哪个消息队列
    public void receive2(Message message){
        System.out.println("收到消息队列中的来了新的消息---" );
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
        System.out.println(message.getClass());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConstants.QUEUE3, durable = "true"),
            exchange = @Exchange(value = RabbitConstants.EXCHANGE,ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC ),
            key = {"item.insert","item.update"}))
    public void listen(String msg){
        System.out.println("接收到消息：" + msg);
    }

}
