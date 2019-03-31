package com.goat.concurrency.atomic;


import com.goat.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class AtomicExample1 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        final Logger myLog = LoggerFactory.getLogger(AtomicExample1.class);
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index = 0; index < clientTotal; index++) {
            exec.execute(() -> {
                try {
                    semp.acquire();
                    add();
                    semp.release();
                } catch (Exception e) {
                    myLog.error("exception", e);
                }
                countDownLatch.countDown();
            });

        }
        countDownLatch.await(); // 这句代码 很关键 没有他  数量就是不对的。。。
        exec.shutdown();
        myLog.info("count:{}", count.get());
    }

    private static void add() {
        count.incrementAndGet();
//        count.compareAndSet(1,2);
    }
}
