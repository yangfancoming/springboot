package com.goat.concurrency.myvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/21---17:09
 */
public class MyData {

    volatile int num = 0;

    public void set(){
        this.num = 30;
    }

    // 验证 volatile 不保证原子性
    public void addPlusPlus(){
        this.num++;
    }

    //解决方案一： 加上 synchronized 可以 保证原子性
    public synchronized void addPlusPlus2(){
        this.num++;
    }

    AtomicInteger aci = new AtomicInteger();

    //解决方案二： 使用  Atomic 保证原子性
    public  void addPlusPlus3(){
        aci.getAndIncrement();// 对应 i++
    }
}
