package com.goat.controller;


import com.goat.domain.MyMoney;
import com.goat.service.TestService;
import com.goat.service.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/test")
public class JpaTestController {

    @Autowired
    public TestService testService;

    //    http://localhost:8657/test/test4
    @GetMapping("/test4")
    public void test4(){
        List<MyMoney> lists = init();
        testService.saveAll1(lists);
    }

    //    http://localhost:8657/test/test5
    @GetMapping("/test5")
    public void test5(){
        List<MyMoney> lists = init();
        testService.saveAll2(lists);
    }

    @Autowired
    TestService2 testService2;
    //    http://localhost:8657/test/test1
    @GetMapping("/test1")
    public void test1(){
        List<MyMoney> lists = init();
        testService2.saveAll2(lists);
    }
    //    http://localhost:8657/test/test2
    @GetMapping("/test2")
    public void test2(){
        List<MyMoney> lists = init();
        testService2.saveAll22(lists);
    }

    public  List<MyMoney> init(){
        MyMoney myMoney1 = new MyMoney(1L,"111");
        MyMoney myMoney2 = new MyMoney(2L,"222");
        MyMoney myMoney3 = new MyMoney(3L,"333");
        List<MyMoney> lists = Arrays.asList(myMoney1,myMoney2,myMoney3);
        return lists;
    }
}
