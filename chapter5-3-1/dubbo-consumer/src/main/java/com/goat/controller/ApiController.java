package com.goat.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.goat.service.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiController {

    @Reference
    public HelloService helloService;   // 这里注意  api 模块的 service 使用的是 @Reference  sos 而不是  @Resource ！！！

    // http://localhost:7531/sayHello/123
    @RequestMapping("/sayHello/{name}")
    public String hello(@PathVariable("name") String name) {
        System.out.println("消费者项目 发起调用。。。。。。");
        return helloService.sayHello(name);
    }

}
