package com.goat.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---21:46
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }

    }
}