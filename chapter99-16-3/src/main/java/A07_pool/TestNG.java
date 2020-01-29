package A07_pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestNG {
    // 使用Lambda表达式创建Runnable对象，线程类
    public static Runnable target = () -> {
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值为:" + i);
        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建足够的线程来支持4个CPU并行的线程池   创建一个具有固定线程数（6）的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 向线程池中提交两个线程
        Future<?> result1 = pool.submit(target);
        Future<?> result2 = pool.submit(target);
        Future<?> result3 =  pool.submit(target);

        System.out.println("result1的结果---" + result1.get());
        System.out.println("result2的结果---" + result2.get());
        System.out.println("result3的结果---" + result3.get());
        pool.shutdown(); // 关闭线程池
    }

}
