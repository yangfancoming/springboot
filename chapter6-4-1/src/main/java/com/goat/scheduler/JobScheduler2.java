package com.goat.scheduler;

import com.goat.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: CronTrigger 触发器
 * @date 2018/11/26---13:52
 */
public class JobScheduler2 {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("jobName", "jobGroup")  //定义job的名字和组
                .usingJobData("name", "yanjun")  //传参数，key:name value:yanjun
                .usingJobData("age", 18)  //传参数，key:age value:18
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "triggerGroup")
                .withSchedule(CronScheduleBuilder
                .cronSchedule("0/1 * * * * ?")) //每一秒执行一次
                .build();

            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start(); //开始执行
    }

}
