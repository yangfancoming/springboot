package com.goat.concurrency.lock.deadlock;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: 17 行 开始 都在等对方 释放锁 后自己进入  但是 谁也不会释放  导致谁也走不下去
 * @ author  山羊来了
 * @ date 2019/4/30---9:37
 */
public class Lock2 extends DeadLock implements Runnable {

    @Override
    public void run() {
        synchronized (o2) {
            try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName() + "进入同步块o2准备进入o1");// 显示进入o2块
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "已经进入同步块o1");// 显示进入o1块
            }
        }
    }
}
