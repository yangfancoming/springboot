package A07_pool;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNG {
    // 使用Lambda表达式创建Runnable对象，线程类
    Runnable target = () -> {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值为:" + i);
        }
    };

    @Test
    public void test(){
        // 创建足够的线程来支持4个CPU并行的线程池
        // 创建一个具有固定线程数（6）的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 向线程池中提交两个线程
        pool.submit(target);
        pool.submit(target);
        pool.shutdown(); // 关闭线程池
    }

}
