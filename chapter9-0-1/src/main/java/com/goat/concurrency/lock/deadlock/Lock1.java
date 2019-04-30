package com.goat.concurrency.lock.deadlock;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/30---9:37
 */
public class Lock1 extends DeadLock implements Runnable {

    @Override
    public void run() {
        synchronized (o1) {// 为o1加锁
            try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();} // 获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
            System.out.println(Thread.currentThread().getName() + "进入同步块o1准备进入o2");// 显示进入o1块
            synchronized (o2) {// 为o2加锁
                System.out.println(Thread.currentThread().getName() + "已经进入同步块o2");// 显示进入o2块
            }
        }
    }
}
