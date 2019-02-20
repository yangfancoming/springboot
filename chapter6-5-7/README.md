# 异步任务 与 重试机制 结合 注意点：
    1. @Async @Retryable 可以配合 使用  异步 和 重试 机制 都可以正常实现 
       implements AsyncUncaughtExceptionHandler 中的 handleUncaughtException  可以进入异常捕获 
       但是不能加入  @Recover  因为 一旦加入 @Recover 则不会 进入 handleUncaughtException 异常捕获
       handleUncaughtException 方法 比 @Recover 方法 提供的参数信息 更加丰富
       比如 handleUncaughtException 可以获取 异常方法的 方法名