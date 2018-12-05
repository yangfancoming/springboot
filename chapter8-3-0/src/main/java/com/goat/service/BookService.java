package com.goat.service;

//import com.goat.bean.Book;
import com.goat.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2018/9/29.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/29---15:25
 *
 *  启动该项目后， 使用test 方法  发送广播消息， 一旦监听到消息队列中有消息发来 那么久触发该方法
 *  打印：收到消息队列中的来了新的消息---Book{bookName='西游记', author='陆小曼'}
 */

@Service
public class BookService {

    @RabbitListener(queues = "goat.fuck") // 监听消息队列的内容
    public void receive(Book book){
        System.out.println("收到消息队列中的来了新的消息---" + book);
    }

    @RabbitListener(queues = "bitch.fuck") // 监听消息队列的内容
    public void receive2(Message message){
        System.out.println("收到消息队列中的来了新的消息---" );
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
        System.out.println(message.getClass());
    }
}
