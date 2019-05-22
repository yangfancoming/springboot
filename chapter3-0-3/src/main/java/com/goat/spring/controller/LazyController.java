package com.goat.spring.controller;


import com.goat.spring.lazy.MyLazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("lazy")
public class LazyController {

    /**
     MyLazy 类 只加 @Component 项目启动后  直接创建了该bean
     i am construct method of MyLazy
     MyLazy 类 加上 @Component 和 @Lazy 后 只在调用MyLazy对象的方式时，才执行了MyLazy的构造方法
     sos  实际测试 失败！  直接创建了该bean  是因为使用了  @Autowired MyLazy myLazy;
    */

    // http://localhost:8303/lazy/test1
    @GetMapping("/test1")
    public void test1(){
        MyLazy.test(); // 因为是 静态方法  所以 Spring不用去new 这个类
    }

    // http://localhost:8303/lazy/test2
    @GetMapping("/test2")
    public void test2(){
        MyLazy myLazy = new MyLazy();
        myLazy.sayHello(); //查看控制台信息  实现了懒加载
    }
}
