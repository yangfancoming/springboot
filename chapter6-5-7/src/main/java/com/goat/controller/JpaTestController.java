package com.goat.controller;


import com.goat.domain.MyMoney;
import com.goat.service.TestService;
import com.goat.service.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;


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
     *  异步任务  同一个方法 多线程调用 无返回值的情况
     *  异常可以在 自定义处理器里捕获 如果定义 aop异常拦截 则会先进入aop异常拦截 然后再进入 自定义处理器
     *  在 @Retryable 重试机制 情况下  aop异常拦截 会调用3次   而 自定义异常处理器 则 只调用一次
     *   对象的创建  放在循环外面 否则报错：
        进入自定义 错误 handler  Exception message - identifier of an instance of com.goat.domain.MyMoney was altered from 174 to 176;
     正确的做法是 放在循环体里面

     由于 testService2.saveAll2(lists) 方法 有 @Async("asyncTaskExecutor") 异步注解  因此 这里的 for循环 会是多线程的调用
     从 插入 数据库 记录就可以看出 是多线程插入的结果
    */
    @GetMapping("/test1")
    public void test1(){
        // List<MyMoney> lists = init(); //  不能放在循环体外面
        for (int i = 0; i <5 ; i++) {
            List<MyMoney> lists = init(); // 模仿 restTemplate 远程get数据  然后 save到本地数据库
            testService2.saveAll2(lists,i+""); // 应该 放在循环体里面
        }
    }

    /**  http://localhost:8657/test/test12
     *  异步任务   同一个方法  多线程调用  有返回值的情况   异常需要自己捕获   或者  aop 捕获

    */
    @GetMapping("/test12")
    public void test12(){
        List<Future<List<MyMoney>>> temps = new ArrayList<>(); // 记录多个 线程实例
        for (int i = 0; i <5 ; i++) {
            List<MyMoney> lists = init(); // 模仿 restTemplate 远程get数据  然后 save到本地数据库
            Future<List<MyMoney>> listFuture = testService2.saveAll21(lists, i + "");// 应该 放在循环体里面
            temps.add(listFuture); // 保存 多个线程实例
        }

        while (temps.size()>0){ // 判断 多个线程 实例的 执行状态
            for (int i = 0; i < temps.size(); i++) {
                if (temps.get(i).isDone()){
                    temps.remove(i); // 遍历出执行完毕的线程实例 并删除 直到所有线程执行完毕   跳出 死循环
                    System.out.println("删除" + i + "size数量：" + temps.size());
                }
            }
        }
        System.out.println("所有线程任务 全部完成了！！！！！！！！");
    }


    public  List<MyMoney> init(){
        MyMoney myMoney1 = new MyMoney(1L,"111");
        MyMoney myMoney2 = new MyMoney(2L,"222");
        MyMoney myMoney3 = new MyMoney(3L,"333");
        List<MyMoney> lists = Arrays.asList(myMoney1,myMoney2,myMoney3);
        return lists;
    }
}
