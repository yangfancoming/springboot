package com.goat.controller;


import com.goat.domain.MyMoney;
import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/test")
public class JpaTestController {

    @Autowired
    public TestService testService;


    // sos  两个方法 在做并发测试时 要注意原始值 不能与两个方法中的设置值相同   save 后 version 值 并不会增加

//    http://localhost:8420/test/test1
    @GetMapping("/test1")
    public void test1() throws InterruptedException {
        Optional<MyMoney> myMoney = testService.findById(1L);
        MyMoney haha = myMoney.get();
        haha.setCol1("1111");
        System.out.println("test1 准备 save,version=====" + haha.getVersion());
        Thread.sleep(10000); // 先从数据库取出记录后   进行线程睡眠  让 test2 去修改  sos Thread.sleep(10000); 不会阻塞其他的请求。
        testService.save(haha); // 触发事务1
        System.out.println("test1 save。。。。。。。。。。");

    }

    //    http://localhost:8420/test/test2
    @GetMapping("/test2")
    public void test2(){
        Optional<MyMoney> myMoney = testService.findById(1L);
        MyMoney haha = myMoney.get();
        haha.setCol1("2222");
        System.out.println("test2 准备 save,version=====" + haha.getVersion());
        testService.save(haha);// 触发事务2
        System.out.println("test2 save。。。。。。。。。。");
    }

    @GetMapping("/test3")
    public void test3(){
        testService.update("567",1L);// 触发事务2
    }
    //    http://localhost:8420/test/test4
    @GetMapping("/test4")
    public void test4(){
        MyMoney myMoney = new MyMoney();
        myMoney.setCol1("333");
        testService.save(myMoney);
    }
}
