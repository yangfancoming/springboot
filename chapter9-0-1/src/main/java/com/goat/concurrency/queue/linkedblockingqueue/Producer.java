package com.goat.concurrency.queue.linkedblockingqueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---15:25
 */
public class Producer implements Runnable {

    private String producerName;
    private WorkDesk workDesk;

    public Producer(String producerName, WorkDesk workDesk) {
        this.producerName = producerName;
        this.workDesk = workDesk;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(producerName + "洗好一个盘子");
                workDesk.washDish();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
