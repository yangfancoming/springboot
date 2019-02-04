package async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

@Component
public class Task {

    public static Random random =new Random();

    @Async //这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public Future<String> doTaskOne() throws Exception {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async // 定义一个线程任务
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("f3 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }

}
