package com.goat.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


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
