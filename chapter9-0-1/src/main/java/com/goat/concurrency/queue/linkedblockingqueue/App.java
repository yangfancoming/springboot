package com.goat.concurrency.queue.linkedblockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---15:26
 */
public class App {


    public static void main(String[] args) {
        WorkDesk workDesk = new WorkDesk();

        ExecutorService service = Executors.newCachedThreadPool();
        //四个生产者线程
        Producer producer1 = new Producer("生产者-1-", workDesk);
        Producer producer2 = new Producer("生产者-2-", workDesk);
        Producer producer3 = new Producer("生产者-3-", workDesk);
        Producer producer4 = new Producer("生产者-4-", workDesk);
        //两个消费者线程
        Consumer consumer1 = new Consumer("消费者-1-", workDesk);
        Consumer consumer2 = new Consumer("消费者-2-", workDesk);

        service.submit(producer1);
        service.submit(producer2);
        service.submit(producer3);
        service.submit(producer4);
        service.submit(consumer1);
        service.submit(consumer2);
        /**
         总的来说生产者的速度是会大于消费者的速度的，但是因为阻塞队列的缘故，所以我们不需要控制阻塞，当阻塞队列满的时候，生产者线程就会被阻塞，直到不再满。
         反之亦然，当消费者线程多于生产者线程时，消费者速度大于生产者速度，当队列为空时，就会阻塞消费者线程，直到队列非空
        */
    }
}
