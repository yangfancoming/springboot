package com.goat.concurrency.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 两个 synchronized 方法
 * @ author  山羊来了
 * @ date 2019/4/22---23:36
 */
public class Phone implements Runnable {

    /*好比 家里的大门锁*/
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+ "\t sendSMS");
        sendEmail();// 在 synchronized 锁的 sendSMS 方法中 再调用 同样是 synchronized 锁的 sendEmail 方法
    }

    /*好比 家里进入大门后的 卫生间锁*/
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+ "\t sendEmail---");
    }

    @Override
    public void run() {
        get();
    }
    Lock lock = new ReentrantLock();// 不加参数  默认为 非公平锁

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ "\t get");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ "\t set");
        } finally {
            lock.unlock();
        }
    }

}
