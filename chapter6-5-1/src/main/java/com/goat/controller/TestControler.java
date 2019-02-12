package com.goat.controller;


import com.goat.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;


@RestController
public class TestControler {

    @Autowired
    private AsyncTask asyncTask;

    //    http://localhost:8651/test
    @GetMapping("/test")
    public String hi() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) { // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
        return "启动计划任务！";
    }

}
