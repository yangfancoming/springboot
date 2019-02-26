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
    /**  http://localhost:8657/test/test1
     *   对象的创建  放在循环外面 否则报错：
        进入自定义 错误 handler  Exception message - identifier of an instance of com.goat.domain.MyMoney was altered from 174 to 176;
     正确的做法是 放在循环体里面

     由于 testService2.saveAll2(lists) 方法 有 @Async("asyncTaskExecutor") 异步注解  因此 这里的 for循环 会是多线程的调用
     从 插入 数据库 记录就可以看出 是多线程插入的结果


    */
    @GetMapping("/test1")
    public void test1(){
        // List<MyMoney> lists = init(); //  不能放在循环体外面
        for (int i = 0; i <10 ; i++) {
            List<MyMoney> lists = init(); // 模仿 restTemplate 远程get数据  然后 save到本地数据库
            testService2.saveAll2(lists); // 应该 放在循环体里面
        }
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
