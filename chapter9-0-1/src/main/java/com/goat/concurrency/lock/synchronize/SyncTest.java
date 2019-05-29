package com.goat.concurrency.lock.synchronize;

/**
 * 题目：判断打印的是“one” or “two”
 *
 * 1.两个普通同步方法，两个线程，标准打印,打印 // one two
 *
 * 执行结果是  three one two
 *
 Java中两个线程是否可以同是否问一个对象的两个不同的synchronized方法????"   答案是: 不可以!!!
 多个线程访问同一个类的synchronized方法时, 都是串行执行的 ! 就算有多个cpu也不例外 !
 synchronized方法使用了类java的内置锁, 即锁住的是方法所属对象本身.
 同一个锁某个时刻只能被一个执行线程所获取, 因此其他线程都得等待锁的释放.
 因此就算你有多余的cpu可以执行, 但是你没有锁, 所以你还是不能进入synchronized方法执行,CPU因此而空闲.
 如果某个线程长期持有一个竞争激烈的锁, 那么将导致其他线程都因等待所的释放而被挂起, 从而导致CPU无法得到利用, 系统吞吐量低下.
 因此要尽量避免某个线程对锁的长期占有 !
 *
 */
public class SyncTest {


    public static void main(String[] args) {
        Number number = new Number();
        new Thread(()->number.getOne()).start();
        new Thread(()->number.getTwo()).start();
        new Thread(()->number.getThree()).start();
    }
}
