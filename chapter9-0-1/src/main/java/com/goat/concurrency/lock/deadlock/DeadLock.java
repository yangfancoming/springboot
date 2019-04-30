package com.goat.concurrency.lock.deadlock;
/**
 死锁演示
 */
public class DeadLock  {

    public static final Object o1 = new Object();
    public static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Lock1()).start();
        new Thread(new Lock2()).start();
    }
}
