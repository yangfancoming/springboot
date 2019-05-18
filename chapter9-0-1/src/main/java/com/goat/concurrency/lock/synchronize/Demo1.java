package com.goat.concurrency.lock.synchronize;

/**
 * Created by 64274 on 2019/5/18.
 *
 * @ Description: synchronized 关键字 对某个对象加锁  锁代码块
 * @ author  山羊来了
 * @ date 2019/5/18---10:47
 */
public class Demo1 {

    private static int count = 0;

    private static final Object obj = new Object();

    public static void test(){
        synchronized (obj) { // 任何线程要执行下面的代码，都必须先拿到lock锁，锁信息记录在堆内存对象中的，不是在栈引用中
            // 如果lock已经被锁定，其他线程再进入时，就会进行阻塞等待 所以 synchronized 是互斥锁
            System.out.println(Thread.currentThread().getName() + "我的 count = " + count++);
        }
        // 当代码块执行完毕后，锁就会被释放，然后被其他线程获取
    }


    /*  如果要锁的代码块 就是整个函数体内  那么可以直接 写成 锁函数  见 Demo2 */

}
