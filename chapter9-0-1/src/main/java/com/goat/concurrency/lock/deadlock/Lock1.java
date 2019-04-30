package com.goat.concurrency.lock.deadlock;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: 17 行 开始 都在等对方 释放锁 后自己进入  但是 谁也不会释放  导致谁也走不下去
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
            System.out.println(Thread.currentThread().getName() + "注释掉上面代码  解决死锁");// 解决死锁
        }
    }
}
