package com.goat.concurrency.lock;

import com.goat.concurrency.model.Phone;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 递归锁 可重入锁
 * @ author  山羊来了
 * @ date 2019/4/22---23:30
 */
public class MyReentrantLock {

    /**
     * 指的是 同一线程外层函数获得锁之后，内存递归函数仍然能获取该所的代码，
     * 在同一个线程在外层方法获取锁的时候，在进入内存方法会自动获取锁
     * 即： 线程可以进入任何一个它已经拥有的锁，锁同步着的代码块。

     执行结果：
     Thread-1	 get
     Thread-1	 set
     Thread-0	 get
     Thread-0	 set
    */

    public static void main(String[] args) {

        Phone phone = new Phone();
        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();
    }




}
