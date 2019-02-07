package com.goat.scheduler;


import com.goat.job.TestJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.concurrent.TimeUnit;

/**
     * @Description: SimpleTrigger 触发器
     * @author: 杨帆
     * @Date:   2018/11/26
*/

public class TestScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //1. 从工厂中获取调度器实例 （Scheduler）
        Scheduler scheduled = StdSchedulerFactory.getDefaultScheduler();

        //2. 获取任务实例
        JobDetail detail = JobBuilder.newJob(TestJob.class)  // 加载任务类  (该任务类必须实现 Job 接口)
                .withIdentity("job1", "group1") // P1 = 任务名称(唯一实例)   P2 = 任务组名称
                .usingJobData("jobSays", "Hello World!") // map 属性  可以在 执行类中 获取
                .usingJobData("myFloatValue", 3.141f)   // map 属性  可以在 执行类中 获取
                .build();
        /*  在 任务类中 通过 jobExecutionContext 也可以获取
        System.out.println("名称"+ detail.getKey().getName()); // 名称job1
        System.out.println("组名称"+ detail.getKey().getGroup()); // 组名称group1
        System.out.println("任务类"+ detail.getJobClass()); // 任务类class com.goat.job.TestJob
        * */
        //3. 获取触发器  (SimpleTrigger)
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "gourp1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInSeconds(2))
                .build();
        // 调度器 关联 任务和触发器，保证按照触发器定义的条件执行任务
        scheduled.scheduleJob(detail,trigger);
        scheduled.start(); // 开启调度
        TimeUnit.MINUTES.sleep(1);// sos 不加这句代码  任务会直接结束。。。
        scheduled.shutdown();  //结束调度
    }



}
