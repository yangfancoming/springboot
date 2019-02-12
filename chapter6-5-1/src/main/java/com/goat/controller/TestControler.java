package com.goat.controller;


import com.goat.task.AsyncTask;
import com.goat.model.User;
import com.goat.task.SyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;


@RestController
public class TestControler {

    @Autowired
    private AsyncTask asyncTask;

    // 异步任务测试   http://localhost:8651/asyn_test
    @GetMapping("/asyn_test")
    public String hi() throws Exception {
        long start = System.currentTimeMillis();
        User user = new User(11,"goat");
        Future<User> task1 = asyncTask.doTaskOne(user);
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree("wahaha");
        asyncTask.doTaskFour("wahaha");
        asyncTask.doTaskFive();
        Future<String> task6 = asyncTask.doTaskSix(11);

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()&& task6.isDone()) { // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

//        //如果都执行完就可以跳出循环,isDone方法如果此任务完成，true
//        for (; ; ) {
//            if (task4.isDone() && task5.isDone() && task6.isDone()) {
//                break;
//            }
//        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
        return "启动计划任务！";
    }

    @Autowired
    private SyncTask syncTask;

    // 同步任务测试   http://localhost:8651/sync_task
    @GetMapping("sync_task")
    public long exeSyncTask() throws InterruptedException {

        long begin = System.currentTimeMillis();

        String task4 = syncTask.task4();
        String task5 = syncTask.task5();
        String task6 = syncTask.task6();

        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("执行总耗时=" + total);//固定6000
        return total;
    }

}
