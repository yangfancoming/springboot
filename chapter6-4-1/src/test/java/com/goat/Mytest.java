package com.goat;


import com.goat.job.MyJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {


    @Test
    public void test() throws SchedulerException, InterruptedException {
        //1. 从工厂中获取调度器实例 （Scheduler）
        Scheduler scheduled = StdSchedulerFactory.getDefaultScheduler();

        //2. 获取任务实例
        JobDetail detail = JobBuilder.newJob(MyJob.class)  // 加载任务类  (该任务类必须实现 Job 接口)
                .withIdentity("job1", "group1") // P1 = 任务名称(唯一实例)   P2 = 任务组名称
                .build();
        System.out.println("名称"+ detail.getKey().getName()); // 名称job1
        System.out.println("组名称"+ detail.getKey().getGroup()); // 组名称group1
        System.out.println("任务类"+ detail.getJobClass()); // 任务类class com.goat.job.MyJob
        //3. 获取触发器
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
