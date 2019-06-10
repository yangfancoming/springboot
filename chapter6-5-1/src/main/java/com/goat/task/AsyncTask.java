package com.goat.task;

import com.goat.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

/**
     * @Description: 异步任务 方式二 ： springBoot 自带注解实现
     * @author: Goat
     * @Date:   2019/2/12
*/
@Component
public class AsyncTask {

    public static Random random = new Random();

    /**
     * @Title：
     * @Description:
     * @author fan.yang
     * @date 2014年12月19日 上午10:18:20
     * @param user  指定参数类型
     * @return  Future<User>  指定返回值类型
     * @Date:   2019/2/12
     */
    @Async //定义一个线程任务 , 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public Future<User> doTaskOne(User user) throws InterruptedException {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        if (true)  throw new IllegalArgumentException("111"); // 抛出自定义异常后 在 MyAsyncExceptionHandler 类中  会被拦截到！
        return new AsyncResult<>(user);
    }

    @Async("asyncTaskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree(String name) throws InterruptedException {
        System.out.println("f3 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(name);
    }


    /**
     * 最简单的异步调用，无参数 无返回值
     */
    @Async
    public void doTaskFive() throws InterruptedException {
        System.out.println("f5 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务五");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务五，耗时：" + (end - start) + "毫秒");
    }

    /**
     *  基于@Async注解的 带有参数的异步调用 异步方法可以传入参数
     * 	对于 无返回值的异步方法 ，异常会被 AsyncUncaughtExceptionHandler 处理掉
     * @param name
     */
    @Async("asyncTaskExecutor") // 使用 指定的线程池！
    public void doTaskFour(String name) throws InterruptedException {
        System.out.println("f4 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        System.out.println("开始做任务四");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务四，耗时：" + (end - start) + "毫秒");
        throw new IllegalArgumentException(name); // 抛出自定义异常后 在 MyAsyncExceptionHandler 类中  会被拦截到！
    }

    /**
     * 异常调用返回Future
     * 	对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，需要我们在方法中捕获异常并处理
     *  或者在调用方在调用Futrue.get时捕获异常进行处理
     * @param i
     * @return
     */
    @Async
    public Future<String> doTaskSix(int i) {
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<>("success:" + i);
            System.out.println("完成任务六，耗时：" );
            if (true)  throw new IllegalArgumentException("a");
        } catch (InterruptedException e) {
            future = new AsyncResult<>("error");
        } catch(IllegalArgumentException e){
            future = new AsyncResult<>("error-IllegalArgumentException");
        } catch (RuntimeException e){
            future = new AsyncResult<>("error-RuntimeException");
        }catch (Exception e){
            future = new AsyncResult<>("error-Exception");
        }
        return future;
    }

}
