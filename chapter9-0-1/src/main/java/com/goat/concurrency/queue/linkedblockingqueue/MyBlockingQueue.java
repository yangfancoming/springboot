package com.goat.concurrency.queue.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---19:59
 */
public class MyBlockingQueue extends Thread {

    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
    private int index;
    public MyBlockingQueue(int i) {
        this.index = i;
    }
    @Override
    public void run() {
        try {
            queue.put(String.valueOf(this.index));
            System.out.println("{" + this.index + "} in queue!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        /** 使用线程池 进行多线程 往队列里添加数据 */
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyBlockingQueue(i));
        }

        /** 另启一个线程 死循环从队列中 消费数据  */
        Thread thread = new Thread(()->{
            try {
                while (true) {
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println("======="+MyBlockingQueue.queue.size());
                    if(MyBlockingQueue.queue.isEmpty())
                        break;
                    String str = MyBlockingQueue.queue.take();
                    System.out.println(str + " has take!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pool.submit(thread);
        pool.shutdown();
    }
}
