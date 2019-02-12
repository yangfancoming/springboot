package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---20:18
 *
 我们通过使用ThreadPoolTaskExecutor创建了一个线程池，同时设置了以下这些参数，说明如下表：

 核心线程数10：线程池创建时候初始化的线程数
 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
 缓冲队列100：用来缓冲执行任务的队列
 允许线程的空闲时间30秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
 */

@Configuration
public class TaskExecutorPoolConfig {
    @Bean("asyncTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//线程池维护线程的最少数量
        executor.setMaxPoolSize(20);//线程池维护线程的最大数量
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30);//线程池维护线程所允许的空闲时间,TimeUnit.SECONDS
        executor.setThreadNamePrefix("asyncTaskExecutor");
        // 线程池对拒绝任务的处理策略: CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
