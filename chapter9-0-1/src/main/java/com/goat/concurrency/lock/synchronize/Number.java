package com.goat.concurrency.lock.synchronize;

/**
 * Created by 64274 on 2019/5/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/29---14:03
 */
public class Number {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

//    public synchronized void getOne(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {}
//        System.out.println("one");
//    }
//
//    public synchronized void getTwo(){
//        System.out.println("two");
//    }

    public  void getOne(){
        synchronized (lock1) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            System.out.println("one");
        }

    }

    public  void getTwo(){
        synchronized (lock2) {
            System.out.println("two");
        }
    }

    public void getThree(){
        System.out.println("three");
    }

}
