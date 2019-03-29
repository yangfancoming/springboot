package com.goat.controller;

import com.goat.event.OrderCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/28---17:45
 */

@RestController
public class StartController {

    @Autowired
    ApplicationContext applicationContext;

    //   http://localhost:8761/test
    @GetMapping("/test")
    public String test(){
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(applicationContext);
        System.out.println("发布订单创建事件！");
        applicationContext.publishEvent(orderCreateEvent); // 发布事件
        return "";
    }
}
