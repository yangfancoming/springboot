package com.goat.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---8:33
 */
public class App2 {


    /**
     我新建了大小为3的队列，把这个队列传给生产者和消费者，它们公用这个队列，满的时候生产者阻塞，空的时候消费者阻塞，然后开启生产者和消费者进程
    */
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3, true);
        Consumer consumer = new Consumer(blockingQueue);
        ProducerOffer producerOffer = new ProducerOffer(blockingQueue);

        new Thread(producerOffer).start();
        for(int i=0;i<10000;i++) {
            int a = i*2312/234*12;
        }
        new Thread(consumer).start();
    }
    /*  参看图 阻塞队列.png
        取出来的元素0，1，2，然后直接是8，因为3-7根本没有放到队列里面，offer不会自己阻塞，会直接跳过这个插入的过程。
        这个和put不一样，put会一直等待，就是说程序会一直停留在blockingQueue.put那一句，offer会跳过blockingQueue.offer那一句，而进入下一个while循环，这样实际插入队列的数字就会不连续了。
        主函数里面的for循环是为了让生产者和消费者隔开一段时间，以展示offer的效果。
    */
}
