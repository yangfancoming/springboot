package com.goat.concurrency.queue.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---8:33
 */
public class App {


    /**
     我新建了大小为3的队列，把这个队列传给生产者和消费者，它们共用这个队列，满的时候生产者阻塞，空的时候消费者阻塞，然后开启生产者和消费者进程
    */
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3, true);
        ProducerPut producerPut = new ProducerPut(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producerPut,"producerPut").start();
        new Thread(consumer,"consumer").start();
    }
    /* 生产者最多连续生产3次，然后队列满了，要等待消费者消费，消费者同理 */
}
