package com.goat.concurrency.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *  生产数字，从0一直到19，然后就停工了，中间如果消费者来不及消费，生产者会自动阻塞。
 * @ Description: 生产者，生产方式：put  会阻塞自己
 * @ author  山羊来了
 * @ date 2019/4/23---8:31
 */

public class ProducerPut implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    private static int element = 0;

    public ProducerPut(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        try {
            while(element < 20) {
                System.out.println("将要放进去的元素是："+element);
                blockingQueue.put(element++);
            }
        } catch (Exception e) {
            System.out.println("生产者在等待空闲空间的时候被打断了！");
            e.printStackTrace();
        }
        System.out.println("生产者已经终止了生产过程！");
    }
}
