package com.goat.concurrency.lock.synchronize;

/**
 * Created by 64274 on 2019/5/18.
 *
 * @ Description: synchronized 关键字 对某个对象加锁  锁方法 锁函数
 * @ author  山羊来了
 * @ date 2019/5/18---10:47
 */
public class Demo2 {

    private static int count = 0;

    public synchronized static void test(){
        System.out.println(Thread.currentThread().getName() + "我的 count = " + count++);
    }

}
