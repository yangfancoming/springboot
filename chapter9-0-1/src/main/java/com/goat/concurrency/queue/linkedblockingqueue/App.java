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
    }
}
