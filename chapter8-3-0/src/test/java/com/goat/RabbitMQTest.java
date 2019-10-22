package com.goat;


import com.goat.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpTemplate amqpTemplate;
    @Test
    public void test() {

    }

    /**
         * @Description:  direct 单播 点对点 发送 Map 数据
         * @author: Goat
         * @Param:  convertAndSend  P1= exchange 路由器  P2  routingKey  P3 默认当成消息体 自动序列化后发送
         * @Return:  发送消息后  打开 http://192.168.136.128:15672/#/queues/%2F/goat.shiit  查看Queues Tab页 获取刚发送的消息内容
         * @Date:   2018/9/29
    */
    @Test
    public void convertAndSend() {
        Map<String,Object> map = new HashMap<>(16);
        map.put("msg","这1111是一个msg");
        map.put("data", Arrays.asList("hoho",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","goat.shit",map);
    }
    /**
         * @Description:  direct 单播 点对点 发送 自定实体类 数据
         * @author: Goat
         * @Date:   2018/9/29
    */
    @Test
    public void convertAndSend1() {
        Book book = new Book("山羊来了","你是谁？");
        rabbitTemplate.convertAndSend("exchange.direct","goat.shit",book);
    }

    /**
     * @Description:  fanout 多播（不需要指定 routingKey ）  发送  自定实体类 数据
     * @author: Goat
     * @Date:   2018/9/29
     */
    @Test
    public void convertAndSend2() {
        Book book = new Book("西游记","陆小曼");
        rabbitTemplate.convertAndSend("exchange.fanout","",book);
    }

    @Test
    public void convertAndSend3() { // 不适用交换机  直接发送的到指定队列中
        rabbitTemplate.convertAndSend("myChannel2","直接发送的到指定队列中");
    }
    /**
     * @Description:  接收数据   这里一旦接收到消息后   则队列里无法再获取该条消息
     * @author: Goat
     * @Return:   自动消息的反序列化   class java.util.HashMap class com.goat.bean.Book 等等
     * @Date:   2018/9/29
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("goat.shiit");
        // class java.util.HashMap
        // class com.goat.bean.Book
        System.out.println(o.getClass());
        // {msg=这是一个msg, data=[hoho, 123, true]}
        //  Book{bookName='西游记', author='陆小曼'}
        System.out.println(o);
    }

}
