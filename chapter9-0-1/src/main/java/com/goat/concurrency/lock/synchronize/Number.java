package com.goat.concurrency.lock.synchronize;

/**
 * Created by 64274 on 2019/5/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/29---14:03
 */
public class Number {

    public synchronized void getOne(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("one");
    }

    public synchronized void getTwo(){
        System.out.println("two");
    }
}
