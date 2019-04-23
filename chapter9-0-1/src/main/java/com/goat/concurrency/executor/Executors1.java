package com.goat.concurrency.executor;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by 64274 on 2019/4/11.
 *
 * @ Description:  固定线程的线程池
 * @ author  山羊来了
 * @ date 2019/4/11---22:25
 */
public class Executors1 {

    /**
     固定线程的线程池
    缺陷：队列是无界队列 LinkedBlockingQueue默认是 Integer.MAX_VALUE容量，
     意味着如果任务足够多，可以存储Integer.MAX_VALUE的Runnable任务，普通服务器内存一定会溢出。
    */
    @Test
    public void test(){
        ExecutorService ex1 = Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++){
            ex1.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        ex1.shutdown();
    }

    /**
     无限线程的线程池
     缺陷：线程池的容量是Integer.MAX_VALUE
     这里的 SynchronousQueue 只能存储一个任务，保证串行化要求。 即理解为：私人订制！！！
     线程的最大上线是Integer.MAX_VALUE结果是0x7fffffff，服务器根本支持不了这么多线程，内存和CPU不支持。很容易造成服务器宕机。
     */
    @Test
    public void test1(){
        ExecutorService ex2 = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            ex2.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        ex2.shutdown();
    }

    /**
     单线程线程池
     缺陷：无界队列，单线程无法发挥线程池的能力，很鸡肋
     同样LinkedBlockingQueue，默认Integer.MAX_VALUE容量。
     */
    @Test
    public void test2(){
        ExecutorService ex3 = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            ex3.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        ex3.shutdown();
    }


    /**
     线程池返回结果
     上面的例子可以使用submit方法，可以接收线程的返回值。
     */
    @Test
    public void test3(){
        ExecutorService ex1 = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new LinkedList<>();
        for (int i=0;i<10;i++){
            Future<String> future = ex1.submit((Callable) () -> Thread.currentThread().getName());
            list.add(future);
        }
        list.stream().forEach((s)-> {
            try {
                System.out.println(s.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        ex1.shutdown();
    }


}
