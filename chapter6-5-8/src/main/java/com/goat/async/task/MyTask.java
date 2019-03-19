package com.goat.async.task;

import com.goat.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class MyTask {

    @Autowired
    AsyncService asyncService;

    /**  方式一： 可以看到 每次都是一个新的线程  直到 第10个线程 对应 sos executor.setCorePoolSize(10) 中的 10
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor6-------------2019-47-19  21:47:50
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor7-------------2019-47-19  21:47:55
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor8-------------2019-48-19  21:48:00
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor9-------------2019-48-19  21:48:05
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor10-------------2019-48-19  21:48:10
     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor1-------------2019-48-19  21:48:15
    */
    @Scheduled(fixedRate = 2 * 1000)
    public void test0() {
        asyncService.test();
    }

    /**
        方式二：   可以看到 方式二  运行结果 与 方式一 是一样的。。。。
    */
//    @Scheduled(fixedRate = 2 * 1000)
//    @Async("asyncTaskExecutor")
//    public void test1() {
//        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
//        long now= System.currentTimeMillis(); // 当前系统时间
//        System.out.println(Thread.currentThread().getName() +"-------------"+ aDate.format(now));
//    }

    /**
     方式三：  这种方式  实现多线程 更加明显

     定时任务哦。。。。。。。。。。。
     asyncTaskExecutor5-------------2019-16-19  22:16:03
     asyncTaskExecutor1-------------2019-16-19  22:16:03
     asyncTaskExecutor4-------------2019-16-19  22:16:03
     asyncTaskExecutor2-------------2019-16-19  22:16:03
     asyncTaskExecutor3-------------2019-16-19  22:16:03
     asyncTaskExecutor1-------------2019-16-19  22:16:03
     asyncTaskExecutor2-------------2019-16-19  22:16:03
     asyncTaskExecutor4-------------2019-16-19  22:16:03
     asyncTaskExecutor5-------------2019-16-19  22:16:03
     asyncTaskExecutor3-------------2019-16-19  22:16:03
     */

    @Scheduled(fixedRate = 2 * 1000)
    public void test2() {
        System.out.println("定时任务哦。。。。。。。。。。。");
        for (int i = 0; i < 10; i++) {
            asyncService.test();
        }
    }


}
