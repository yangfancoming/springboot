package com.goat.concurrency.lock.example00;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/29.
 * 需求：有三位运动员，他们一起参加万米赛跑，但是他们准备的时间不同，要等他们都准备好了再开始一起跑
 * countDownLatch 是采取阻塞主线程的方法实现了线程的统一。他内部有一个计数器，
 * 我们在执行完一次线程任务的时候需要手动的减一个数，在主线程中使用
 * **countDownLatch.await()**监控计数器的状态，直到计数器计到0为止，再执行主线程的代码
 * @ Description: 使用 CountDownLatch 实现
 * @ author  山羊来了
 * @ date 2019/4/29---16:05
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int size = 3;
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            int index = i;
            pool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(index);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + index + "位运动员准备好了");
            });
        }
        countDownLatch.await();   /* 监控计数器的状态，直到计数器计到0为止，再执行主线程的代码*/
        System.out.println(size + "位运动员都准备好了，可以起跑!");
    }

}
