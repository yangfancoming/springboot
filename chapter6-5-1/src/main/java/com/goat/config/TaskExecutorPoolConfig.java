package com.goat.config;

//import com.goat.handler.SpringAsyncExceptionHandler;

import com.goat.handler.MyAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---20:18
 *
 我们通过使用 ThreadPoolTaskExecutor 创建了一个线程池，同时设置了以下这些参数，说明如下表：

 核心线程数10：线程池创建时候初始化的线程数
 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
 缓冲队列100：用来缓冲执行任务的队列
 允许线程的空闲时间30秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
 */

@Configuration
public class TaskExecutorPoolConfig implements AsyncConfigurer { // 通过AsyncConfigurer自定义线程池，以及异常处理

    /**
     * 自定义异步线程池
     * 	如果没有这个方法，则使用默认的线程池
     * @return
     */
    @Bean("asyncTaskExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//线程池维护线程的最少数量(核心线程数)
        executor.setMaxPoolSize(20);//线程池维护线程的最大数量
        executor.setQueueCapacity(100);// 设置队列容量
        executor.setKeepAliveSeconds(30);//线程池维护线程所允许的空闲时间,TimeUnit.SECONDS  设置线程活跃时间（秒）
        executor.setThreadNamePrefix("asyncTaskExecutor"); //设置默认线程名称
        //在配置了spring线程池的情况下，如果某时刻要停止应用，如果没有优雅停机，存在于线程池中的任务将会被强制停止，导致部分任务失败。此时，只需要在线程配置中设置：
        executor.setAwaitTerminationSeconds(60 * 15); //    Spring线程池注册优雅停机 （默认为0，此时立即停止），并没等待xx秒后强制停止
        /**
         * 1. new ThreadPoolExecutor.AbortPolicy():抛出异常java.util.concurrent.RejectedExecutionException
         * 2. new ThreadPoolExecutor.CallerRunsPolicy():用于被拒绝任务的处理程序，它直接再execute方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
         * 3. new ThreadPoolExecutor.DiscardOldestPolicy():如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）
         * 4. new ThreadPoolExecutor.DiscardPolicy():用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务
         * java.util.concurrent.ThreadPoolExecutor.AbortPolicy 这个是默认使用的拒绝策略,如果有要执行的任务队列已满,且还有任务提交,则直接抛出异常信息
         * java.util.concurrent.ThreadPoolExecutor.DiscardPolicy 这个是忽略策略,如果有要执行的任务队列已满,且还有任务提交,则直接忽略掉这个任务,即不抛出异常也不做任何处理.
         * java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy 忽略最早提交的任务.如果有要执行的任务队列已满,此时若还有任务提交且线程池还没有停止,则把队列中最早提交的任务抛弃掉,然后把当前任务加入队列中.
         * java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy 这个是来着不拒策略.如果有要执行的任务队列已满,此时若还有任务提交且线程池还没有停止,则直接运行任务的run方法.
         */
        // (设置拒绝策略)线程池对拒绝任务的处理策略: CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

    // 直接写在方法内的方式
    /**
     @Override
     public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
     AsyncUncaughtExceptionHandler handler = (throwable, method, objects)-> System.out.println("未处理：" + objects[0] + "");
     return handler;
     }
     * */

    // 新建自定义类的方式
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }



}
