package com.goat.concurrency.system.task;


import com.goat.concurrency.system.queue.MyConcurrentLinkedQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


@Component
public class MyLinkedQueueTask {


    @Autowired
    private MyConcurrentLinkedQueue myConcurrentLinkedQueue;


    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


//    @Scheduled(fixedDelay = 2000)
    public void doJob() {

        int coreLen = threadPoolTaskExecutor.getCorePoolSize();
        System.out.println("核心线程池中的线程数量："+coreLen);

        for (int i = 0; i < coreLen; i++) {
            threadPoolTaskExecutor.execute(() -> {
                String s = myConcurrentLinkedQueue.poll();
                System.out.println("### 出队:" + s);
            });
        }
    }

}
