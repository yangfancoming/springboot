package com.goat.concurrency.lock.synchronize;

/**
 * Created by 64274 on 2019/5/18.
 *
 * @ Description: 线程不安全  无锁
 * @ author  山羊来了
 * @ date 2019/5/18---10:47
 */
public class Demo0 {

    private static int count = 0;

    public static void test(){
        System.out.println(Thread.currentThread().getName() + "我的 count = " + count++);
    }

}
