package com.goat.concurrency.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 64274 on 2019/3/31.
 *
 * @ Description: 使用 模板方法 设计模式  防止重复代码
 * @ author  山羊来了
 * @ date 2019/3/31---22:07
 */
public abstract class BaseExample {

    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public void test() throws InterruptedException {
        final Logger myLog = LoggerFactory.getLogger(getClass());
        ExecutorService exec = Executors.newCachedThreadPool();// 定义线程池
        final Semaphore semp = new Semaphore(threadTotal); // 信号量 运行同时并发执行的线程数
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec.execute(() -> {
                try {
                    semp.acquire(); // 信号量 确认
                    add();
                    semp.release(); // 信号量 释放
                } catch (Exception e) {
                    myLog.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await(); // 这句代码 很关键 没有他  数量就是不对的。。。
        exec.shutdown(); // 关闭线程池
    }

    public abstract void add ();

}
