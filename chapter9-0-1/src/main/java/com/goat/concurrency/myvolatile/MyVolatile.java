package com.goat.concurrency.myvolatile;

import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: 证明 volatile 在多线程间的可见性
 * @ author  山羊来了
 * @ date 2019/4/21---17:09
 */
public class MyVolatile {

    /**
     *  在没有 volatile 关键字 的情况下  多线程间是没有可见性的！
     *  主线程死循环 表现为IDEA的红色停止按钮一直常亮 代表主线程一直没有运行结束。  证明 主线程没有读取到 t1 线程更改后30的值
     *
     *   在使用 volatile 关键字 的情况下 多线程间 就存在可见性了！
     *  将 MyData 类中的num属性加上 volatile 关键字后  volatile int num = 0;
     *  主线程没有死循环 表现为主线程红色停止按钮 自动灰掉代表 主线程运行结束。  主线程 可以读取到t1 线程更改后30的值  然后 自动退出 并打印出 更改后的值30
    */
    public static void main(String[] args) {
        MyData myData = new MyData();
        Runnable t1 = ()-> {
            System.out.println(Thread.currentThread().getName() + "\t coming in !");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.set();// 将 t1 线程工作区内 更改 num 变量的副本后  更新到 主内存的
            System.out.println(Thread.currentThread().getName() + "\t set myData value: " + myData.num);
        };

        Thread thread = new Thread(t1);
        thread.setName("aaaa");
        thread.start();

        while (myData.num == 0){
            // 此循环由主线程执行  验证主线程 是否能够可见 其他线程 更新到 主内存中的变量值
//            System.out.println("主线程循环等待："+myData.num); //  为啥 循环了 加上这局代码后 在没加 volatile关键字的情况下 主线程就自动终止了呢？
        }
        System.out.println(Thread.currentThread().getName() + "主线程 运行结束！" + myData.num);
    }

}
