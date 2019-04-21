package com.goat.concurrency.myvolatile;



/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: 证明 volatile 不保证原子性案例演示
 * @ author  山羊来了
 * @ date 2019/4/21---17:09
 */
public class MyVolatile2 {

    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();

        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus(); // 不保证原子性  行时间：0.063s
//                    myData.addPlusPlus2(); // 保证原子性  执行时间：0.07s
                    myData.addPlusPlus3(); // 保证原子性 执行时间：0.062s
                }
            },String.valueOf(i)).start();
        }

        // 一个是主线程 另一个是 GC 线程 两个基本线程
        while (Thread.activeCount()>2){ // 当前程序激活线程数大于2个
            Thread.yield(); // 主线程让步
        }

        /**
         * main	 计算结果是：16689  正确结果是 20 * 1000 =20000  证明了  volatile 不保证原子性
         *  加上 synchronized 关键字后 就可以保证原子性 但是不推荐这么做，synchronized 太重了
        */
        System.out.println(Thread.currentThread().getName()+ "\t 计算结果是：" + myData.num);
        System.out.println(Thread.currentThread().getName()+ "\t 计算结果是：" + myData.aci);

        //执行方法
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");
    }

}
