package com.goat.concurrency.queue.linkedblockingqueue;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---15:26
 */
public class Consumer implements Runnable {

    private String consumerName;
    private WorkDesk workDesk;

    public Consumer(String consumerName, WorkDesk workDesk) {
        this.consumerName = consumerName;
        this.workDesk = workDesk;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(consumerName + "使用一个盘子");
                workDesk.useDish();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
