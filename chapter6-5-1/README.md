# springboot异步任务
    @EnableAsync 与  @Async 两个注解必须配合使用
    
    @Async //这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    @EnableAsync  使 @Async 生效 也就是说 去掉 @EnableAsync 则 @Async 无效 
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
    
# 明显 测试1 为 同步任务   测试2 为异步任务



