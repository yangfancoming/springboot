package com.goat.spring.controller;


import com.goat.spring.lazy.MyLazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("lazy")
public class LazyController {

    @Autowired
    MyLazy myLazy;

    /**
     MyLazy 类 只加 @Component 项目启动后  直接创建了该bean
     i am construct method of MyLazy
     MyLazy 类 加上 @Component 和 @Lazy 后 只在调用MyLazy对象的方式时，才执行了MyLazy的构造方法  doit 实际测试 失败！  直接创建了该bean
    */

    // http://localhost:8303/lazy/test1
    @GetMapping("/test1")
    public void test1(){
        myLazy.sayHello();
    }
}
