package com.goat.controller;

import com.goat.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @Autowired  HelloService helloService;

    // 测试地址：    http://localhost:8341/hello?name=11
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    /**  参见 图1：
     哥是 环绕增强 调用目标方法前执行。。。。。。。。。。。
     哥是前置增强1。。。。。。。。。。。
     哥是前置增强2。。。。。。。。。。。
     sayHiService1
     哥是 环绕增强 调用目标方法后执行。。。。。。。。。。。
     哥是后置增强。。。。。。。。。。。
     哥是后AfterReturning。。。。。。。。。。。
    */

    // 测试地址：    http://localhost:8341/hello1
    @GetMapping("/hello1")
    public String hello1() {
        return helloService.sayHiService1();
    }


    /**
     执行 hello2 Controller
     哥是 环绕增强 调用目标方法前执行。。。。。。。。。。。
     哥是前置增强1。。。。。。。。。。。
     哥是前置增强2。。。。。。。。。。。
     sayHiService2
     哥是 异常增强。。。。。。。。。。。java.lang.RuntimeException: 123
    */
    // 测试地址：    http://localhost:8341/hello2
    @GetMapping("/hello2")
    public String hello2() {
        System.out.println("执行 hello2 Controller");
        return helloService.sayHiService2();
    }
}
