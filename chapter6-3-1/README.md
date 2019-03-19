

    第一步  在service 方法上 添加  @Scheduled(fixedRate = 5000)
    
    第二步  在启动类上  添加 @EnableScheduling  表示开启 基于注解的定时任务 功能