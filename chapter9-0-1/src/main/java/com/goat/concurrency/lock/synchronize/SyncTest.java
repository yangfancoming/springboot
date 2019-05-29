package com.goat.concurrency.lock.synchronize;

/**
 * 题目：判断打印的是“one” or “two”
 *
 * 1.两个普通同步方法，两个线程，标准打印,打印 // one two
 *
 * 执行结果是  one two
 * 我的理解是： Number类中的所有方法 都有 synchronized 修饰 那么就相当于  整个类  是由 synchronized 修饰的
 * 所有 当第一个线程 访问 number 对象时 拿到的锁是 整个对象的锁，所以 其他线程 无法同时访问对象的其他方法！
 *
 */
public class SyncTest {


    public static void main(String[] args) {
        Number number = new Number();
        new Thread(()->number.getOne()).start();
        new Thread(()->number.getTwo()).start();
    }
}
