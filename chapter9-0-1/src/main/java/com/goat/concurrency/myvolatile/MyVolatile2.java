package com.goat.concurrency.myvolatile;


import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: 证明 volatile 不保证原子性案例演示
 * @ author  山羊来了
 * @ date 2019/4/21---17:09
 */
public class MyVolatile2 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 一个是主线程 另一个是 GC 线程 两个基本线程
        while (Thread.activeCount()>2){ // 当前程序激活线程数大于2个
            Thread.yield(); // 主线程让步
        }

        // main	 计算结果是：16689  正确结果是 20 * 1000 =20000  证明了  volatile 不保证原子性
        System.out.println(Thread.currentThread().getName()+ "\t 计算结果是：" + myData.num);
    }

}
