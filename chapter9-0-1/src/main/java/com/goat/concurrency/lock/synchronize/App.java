package com.goat.concurrency.lock.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 64274 on 2019/5/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/18---10:57
 */
public class App {

    public static ExecutorService ex1 = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            ex1.execute(()-> Demo0.test()); // 线程不安全 最大值是 8
            ex1.execute(()-> Demo1.test()); // 0-9
            ex1.execute(()-> Demo2.test()); // 0-9
        }
        ex1.shutdown();
    }
}
