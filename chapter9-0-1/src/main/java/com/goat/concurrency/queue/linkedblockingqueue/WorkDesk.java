package com.goat.concurrency.queue.linkedblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---15:24
 */
public class WorkDesk {

    BlockingQueue<String> desk = new LinkedBlockingQueue<>(10);

    public void washDish() throws InterruptedException {
        desk.put("洗好一个盘子");
    }

    public String useDish() throws InterruptedException {
        return desk.take();
    }
}
