package com.goat.concurrency.lock.example00;

import java.util.concurrent.*;

/**
 * Created by 64274 on 2019/4/29.
 * 需求：有三位运动员，他们一起参加万米赛跑，但是他们准备的时间不同，要等他们都准备好了再开始一起跑
 * @ Description: 使用CyclicBarrier 实现
 * 在这里CyclicBarrier 做法是在自己的构造器中new了一个runnable，等待其他线程都执行完，再执行此runnable中的代码
 * @ author  山羊来了
 * @ date 2019/4/29---16:08
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int size = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size, () -> {
            System.out.println(size + "位运动员都准备好了，可以起跑！");
            pool.shutdownNow();
        });

        for (int i = 0; i < size; i++) {
            int index = i;
            pool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + index + "位运动员准备好了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
