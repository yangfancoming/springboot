package com.goat.controller;


import com.goat.domain.MyMoney;
import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public TestService testService;

//    http://localhost:8420/test/test1
    @RequestMapping("/test1")
    public void test1() throws InterruptedException {
        Optional<MyMoney> myMoney = testService.findById(1L);
        Thread.sleep(10000); // 先从数据库取出记录后   进行线程睡眠  让 test2 去修改
        MyMoney haha = myMoney.get();
        haha.setCol1("123");
        testService.save(haha);
        // sos Thread.sleep(10000); 不会阻塞其他的请求。
        System.out.println("调用test11111111111111111111");

    }

    //    http://localhost:8420/test/test2
    @RequestMapping("/test2")
    public void test2(){
        Optional<MyMoney> myMoney = testService.findById(1L);
        MyMoney haha = myMoney.get();
        haha.setCol1("234");
        testService.save(haha);
        System.out.println("调用test222222222222222222222");
    }
}
