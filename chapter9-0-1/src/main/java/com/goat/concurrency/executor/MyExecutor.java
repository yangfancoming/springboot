package com.goat.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---20:07
 */
public class MyExecutor extends Thread {
    private int index;
    public MyExecutor(int i){
        this.index=i;
    }
    public void run(){
        try{
            System.out.println("["+this.index+"] start....");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println("["+this.index+"] end.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        ExecutorService service= Executors.newFixedThreadPool(4);
        for(int i=0;i<10;i++){
            service.execute(new MyExecutor(i));
            //service.submit(new MyExecutor(i));
        }
        System.out.println("submit finish");
        service.shutdown();
    }
    /**
     看到只能执行4个线程。当执行完一个线程后，才会又执行一个新的线程，也就是说，我们将所有的线程提交后，线程池会等待执行完最后shutdown。
     我们也会发现，提交的线程被放到一个“无界队列里”。这是一个有序队列（BlockingQueue，这个下面会说到）。
     另外它使用了Executors的静态函数生成一个固定的线程池，顾名思义，线程池的线程是不会释放的，即使它是Idle。
     这就会产生性能问题，比如 线程池的大小为200，当全部使用完毕后，所有的线程会继续留在池中，相应的内存和线程切换（while(true)+sleep循环）都会增加。
     如果要避免这个问题，就必须直接使用ThreadPoolExecutor()来构造。可以像通用的线程池一样设置“最大线程数”、“最小线程数”和“空闲线程keepAlive的时间”。
    */
}