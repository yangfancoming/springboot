package com.goat.concurrency.myvolatile;

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
}
