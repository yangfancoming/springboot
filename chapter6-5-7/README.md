# 异步任务 与 重试机制 结合 注意点：
    1. @Async @Retryable 可以配合 使用  异步 和 重试 机制 都可以正常实现 
       implements AsyncUncaughtExceptionHandler 中的 handleUncaughtException  可以进入异常捕获 
       但是不能加入  @Recover  因为 一旦加入 @Recover 则不会 进入 handleUncaughtException 异常捕获
       handleUncaughtException 方法 比 @Recover 方法 提供的参数信息 更加丰富
       比如 handleUncaughtException 可以获取 异常方法的 方法名
       
       
       @Async("asyncTaskExecutor") 注解标记的方法 必须要在 @service 类中 才能实现 自定义异常捕获 进入 AsyncUncaughtExceptionHandler 中
       
       
       
# 异步任务  事务回滚
    说到事务就毕竟麻烦，之前网上查了一下，说不能直接在这个异步任务里面直接加事务，需要引用其他service里面的加事务
    也许网上说的情况和我测试的不一致，也许是spring版本的原因，这里时间有限没有进一步的测试了。
    小伙伴如果知道是哪里有问题可以告诉我下， 然后写的话，尽量本身不要涉及事务，然后引用的service里面加上事务吧。
   