package com.goat.concurrency.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: 生产者，生产方式：offer  不会阻塞自己
 * @ author  山羊来了
 * @ date 2019/4/23---8:34
 */

public class ProducerOffer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    private static int element = 0;


    public ProducerOffer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            while(element < 20) {
                System.out.println("将要放进去的元素是："+element);
                blockingQueue.offer(element++);
            }
        } catch (Exception e) {
            System.out.println("生产者在等待空闲空间的时候被打断了！");
            e.printStackTrace();
        }
        System.out.println("生产者已经终止了生产过程！");
    }
}
