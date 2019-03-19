package com.goat.async.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


@Configuration
public class TaskExecutorPoolConfig implements AsyncConfigurer { // 通过AsyncConfigurer自定义线程池，以及异常处理

    @Bean("asyncTaskExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);//线程池维护线程的最少数量(核心线程数)
        executor.setMaxPoolSize(20);//线程池维护线程的最大数量
        executor.setQueueCapacity(100);// 设置队列容量
        executor.setKeepAliveSeconds(30);//线程池维护线程所允许的空闲时间,TimeUnit.SECONDS  设置线程活跃时间（秒）
        executor.setThreadNamePrefix("asyncTaskExecutor"); //设置默认线程名称
        //在配置了spring线程池的情况下，如果某时刻要停止应用，如果没有优雅停机，存在于线程池中的任务将会被强制停止，导致部分任务失败。此时，只需要在线程配置中设置：
        executor.setAwaitTerminationSeconds(60 * 15); //    Spring线程池注册优雅停机 （默认为0，此时立即停止），并没等待xx秒后强制停止
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}
