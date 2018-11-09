package com.goat.controller;

import com.goat.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

// 测试地址：    http://localhost:8341/hello?name=11
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }


    // 测试地址：    http://localhost:8341/hello1
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        return helloService.SayHiService1();
    }


    // 测试地址：    http://localhost:8341/hello2
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        System.out.println("执行 hello2 Controller");
        return helloService.SayHiService2();
    }
}
