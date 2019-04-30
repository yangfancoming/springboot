package com.goat.concurrency.lock.deadlock;
/**
 死锁演示

 资源互斥： 资源只能供一个线程使用
 请求保持： 拥有资源的线程再请求新的资源的同时  又不释放已占有的资源
 不可剥夺： 已经获得的资源在使用完成前不能剥夺
 循环等待： 各个线程对资源的需求构成一个循环

 */
public class DeadLock  {

    public static final Object o1 = new Object();
    public static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Lock1()).start();
        new Thread(new Lock2()).start();
    }
}
