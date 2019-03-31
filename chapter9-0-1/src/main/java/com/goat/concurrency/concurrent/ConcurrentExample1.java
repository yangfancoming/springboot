package com.goat.concurrency.concurrent;


import com.goat.concurrency.annoations.UnThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 并发模拟 工具类
 *
 * 可以看到 执行结果是错误的 正确的结果应该是：5000
 * */

@UnThreadSafe
public class ConcurrentExample1 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final Logger myLog = LoggerFactory.getLogger(ConcurrentExample1.class);
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

        countDownLatch.await();
        exec.shutdown(); // 关闭线程池
        myLog.info("size:{}", count);

    }

    public static void add() {
       count++;
    }
}
