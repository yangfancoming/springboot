
package com.goat.A.A03.example02;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;


public class App {

    /** 可以看到 for循环 输出的 emperor 地址都是一样的  */
    @Test
    public void test(){
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
            System.out.println(emperor);
        }
    }

    /** 会多次调用 Emperor 的构造方法
     *  由于 对象  并不是在类加载时就创建  而是程序在运行中动态创建的 所以再多线程情况下，存在线程安全问题
     *  解决方法一： 在 getInstance 方法头 加上 synchronized 关键字修饰  不推荐 因为 synchronized 有点重量级了
     *  解决方法二： DCL 单例模式 推荐  double check log  双端检锁 机制
     *  */
    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        int size = 100;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            new Thread(()->{
//                Emperor instance = Emperor.getInstance(); // 线程不安全 会创建多个实例
//                Emperor instance = Emperor.getInstance1(); // 线程安全 但是效率低
                Emperor instance = Emperor.getInstance2(); // 线程安全 但是效率高
                System.out.println(instance);
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");
    }

}
