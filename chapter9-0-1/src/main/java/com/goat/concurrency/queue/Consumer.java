package com.goat.concurrency.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *  消费者一直在消费，queue空的时候自动等待，即使生产者停止了生产，消费者也会等待。
 * @ Description: 消费者调用
 * @ author  山羊来了
 * @ date 2019/4/23---8:32
 */

public class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("取出来的元素是："+blockingQueue.take());
            }
        } catch (Exception e) {
            System.out.println("消费者在等待新产品的时候被打断了！");
            e.printStackTrace();
        }
    }
}
