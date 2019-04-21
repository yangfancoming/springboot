package com.goat.concurrency.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: 理解 CAS （CompareAndSet） 原理 ： 比较当前工作内存中的值和主内存中的值，如果相同则执行修改操作，否则继续比较直到主存和工作内存中的值一致为止。
 * CAS 的缺点：  1.不加锁，保证数据一致性，但是需要多次循环对比 导致系统开销大。2.引出 ABA 问题？？？
 * synchronize ：通过加锁来保证数据一致性，导致并发性能下降
 *
 * @ author  山羊来了
 * @ date 2019/4/21---20:46
 */
public class MyAtomicInteger {

    @Test
    public void test(){
        AtomicInteger aci = new AtomicInteger(5);
        System.out.println(aci.compareAndSet(5, 2019) + "\t 更改后的值为：" + aci.get());
    }

    /** compareAndSet 每次更改失败 都是由于被其他线程 抢先执行，导致主存的值被覆盖，因此需要再次读取一次。*/
    @Test
    public void test1(){
        AtomicInteger aci = new AtomicInteger(5);
        // 模拟其他线程 更改 aci
        aci.set(100);
        System.out.println(aci.compareAndSet(5, 2019) + "\t 更改后的值为：" + aci.get());// 发现期望值冲突  更改失败
    }

    @Test
    public void test2(){
        AtomicInteger aci = new AtomicInteger(5);
        System.out.println(aci.compareAndSet(5, 2019) + "\t 更改后的值为：" + aci.get());
        System.out.println(aci.compareAndSet(5, 2014) + "\t 更改后的值为：" + aci.get()); // 发现期望值冲突  更改失败
    }

    public static void main(String[] args) {

    }
}
