package com.goat.task;

import com.goat.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

/**
     * @Description: 异步任务 方式二 ： springBoot 自带注解实现
     * @author: 杨帆
     * @Date:   2019/2/12
*/
@Component
public class AsyncTask {

    public static Random random = new Random();

    /**
     * @Title：
     * @Description:
     * @author fan.yang
     * @date 2014年12月19日 上午10:18:20
     * @param user  指定参数类型
     * @return  Future<User>  指定返回值类型
     * @Date:   2019/2/12
     */
    @Async //定义一个线程任务 , 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public Future<User> doTaskOne(User user) throws Exception {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(user);
    }

    @Async
//    @Async("asyncTaskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
//    @Async("asyncTaskExecutor")
    public Future<String> doTaskThree(String name) throws Exception {
        System.out.println("f3 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(name);
    }

}
