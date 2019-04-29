package com.goat.concurrency.lock;


import java.util.concurrent.Semaphore;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 信号量，Semaphore 可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可
   　acquire()用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
 　　release()用来释放许可。注意，在释放许可之前，必须先获获得许可。

 public Semaphore(int permits) {          //参数permits表示许可数目，即同时可以允许多少线程进行访问
 sync = new NonfairSync(permits);
 }
 public Semaphore(int permits, boolean fair) {    //这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
 sync = (fair)? new FairSync(permits) : new NonfairSync(permits);
 }

 public void acquire() throws InterruptedException {  }     //获取一个许可
 public void acquire(int permits) throws InterruptedException { }    //获取 n 个许可
 public void release() { }          //释放一个许可
 public void release(int permits) { }    //释放 n 个许可

 * @ author  山羊来了
 * @ date 2019/4/29---15:40
 */
public class MySemaphore {

    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }
}
