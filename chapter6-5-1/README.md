# springboot异步任务
    @EnableAsync 与  @Async 两个注解必须配合使用
    
    @Async //这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    @EnableAsync  使 @Async 生效 也就是说 去掉 @EnableAsync 则 @Async 无效 
    注意：
    @Transactional 注解 放在 @Async 方法上 事务是无效的，无法实现回滚 
    @Async 方法中调用 通过@Autowired 注入的Service 带有 @Transactional 注解时，事务有效，可以回滚
    
# 异步任务 实现方式：

    异步任务方式一 ：使用线程池，创建新的线程去处理
        
    异步任务 方式二 ：
        这种方式，是springBoot自身的一种异步方式，使用注解实现，非常方便，我们在想要异步执行的方法上加上@Async注解，在controller上加上@EnableAsync，即可。
        注意，这里的异步方法，只能在自身之外调用，在本类调用是无效的。
#测试1： 注释掉 所有 @Async 注解的 的控制台 log 
    f1 : http-nio-8651-exec-2   cc5d85e4-6f94-4b15-9c14-ab66d1a31ec6
    开始做任务一
    完成任务一，耗时：1010毫秒
    f2 : http-nio-8651-exec-2   09787ca4-b88a-419a-863f-c34d6e31ecf7
    开始做任务二
    完成任务二，耗时：666毫秒
    f3 : http-nio-8651-exec-2   08bbfc91-34f7-44fe-9bae-6884eef318ec
    开始做任务三
    完成任务三，耗时：6062毫秒
    任务全部完成，总耗时：7739毫秒
    
#测试2： 开启 所有 @Async 注解的 的控制台 log 
    f1 : SimpleAsyncTaskExecutor-1   43d4191a-fe61-4a44-bad2-483c591a678d
    f3 : SimpleAsyncTaskExecutor-3   4b564402-f861-411d-b872-82b377229ae1
    f2 : SimpleAsyncTaskExecutor-2   4722149a-b927-44ac-95ce-754083b8582a
    开始做任务二
    开始做任务三
    开始做任务一
    完成任务三，耗时：1994毫秒
    完成任务一，耗时：4101毫秒
    完成任务二，耗时：6298毫秒
    任务全部完成，总耗时：7008毫秒
    
#测试3： 开启 TaskExecutorPoolConfig 线程池后 的控制台 log 
    f2 : asyncTaskExecutor2   012382ed-364a-4ca3-9267-f0d176e431dd
    开始做任务二
    f1 : asyncTaskExecutor1   d7dda92e-a6ce-406d-80ae-04b106a5317d
    开始做任务一
    f3 : asyncTaskExecutor3   a5b0d675-d32d-4b3e-866d-4578f5c5b1c0
    开始做任务三
    完成任务一，耗时：1403毫秒
    完成任务二，耗时：2818毫秒
    完成任务三，耗时：7970毫秒
    任务全部完成，总耗时：8012毫秒
# 明显 测试1 为 同步任务   测试2 为异步任务

        使用 【@Scheduled】 来创建定时任务 这个注解用来标注一个定时任务方法。 
        通过看 @Scheduled源码可以看出它支持多种参数：
        （1）cron：cron表达式，指定任务在特定时间执行；
        （2）fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
        （3）fixedDelayString：与fixedDelay含义一样，只是参数类型变为String；
        （4）fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
        （5）fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String；
        （6）initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
        （7）initialDelayString：与initialDelay的含义一样，只是将参数类型变为String；
        （8）zone：时区，默认为当前时区，一般没有用到。


