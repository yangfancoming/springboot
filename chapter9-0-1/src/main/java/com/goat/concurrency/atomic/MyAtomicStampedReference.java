package com.goat.concurrency.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: ABA 问题的 产生 和 解决
 * @ author  山羊来了
 * @ date 2019/4/21---23:25
 */
public class MyAtomicStampedReference {

    static AtomicReference<Integer> af = new AtomicReference<>(100);

    /* 解决 ABA 问题  使用原子引用的版本号机制  类似JPA乐观锁  通过记录的 版本号 ，即使过程中 多次操作，最终结果修改成与原来一致，但是版本号是不一致的！ */

    /* ABA 问题的产生 */
    public static void main(String[] args) {

        new Thread(()-> { // t1 线程 进行狸猫换太子操作 不记录版本号
            af.compareAndSet(100,101);
            af.compareAndSet(101,100);
        },"t1").start();


        new Thread(()-> { // t2 线程 在只看结果  不管过程的情况下  可以进行更改
            // 由于 t1  和 t2 线程 不确定谁先执行 ，所以 将 t2 线程 睡眠1秒 来保证  t1 先于 t2 执行
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(af.compareAndSet(100, 2019) + "\t" + af.get());
        },"t2").start();

        // 执行结果： true	2019
    }

    /* ABA 问题的解决 */

    public static class test1 {
       static   AtomicStampedReference<Integer> asf = new AtomicStampedReference<>(100,1);
        public static void main(String[] args) {

            new Thread(()-> { // t3 线程 进行狸猫换太子操作  并记录版本号
                System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + asf.getStamp());
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println(asf.compareAndSet(100, 101, asf.getStamp(), asf.getStamp() + 1));
                System.out.println(Thread.currentThread().getName() + "\t 二次版本号：" + asf.getStamp());

                System.out.println(asf.compareAndSet(101, 100, asf.getStamp(), asf.getStamp() + 1));
                System.out.println(Thread.currentThread().getName() + "\t 三次版本号：" + asf.getStamp());
            },"t3").start();

            new Thread(()-> { // t4 线程
                int stamp = asf.getStamp();
                System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + asf.getStamp());
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println(asf.compareAndSet(100, 2019, stamp, stamp + 1));
                System.out.println(Thread.currentThread().getName() + "\t 二次版本号：" + asf.getStamp());
            },"t4").start();

            /**
             t3	 第一次版本号：1
             t4	 第一次版本号：1
             true
             t3	 二次版本号：2
             true
             t3	 三次版本号：3
             false
             t4	 二次版本号：3
            */
        }
    }
}
