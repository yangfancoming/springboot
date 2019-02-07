package com.goat.scheduler;

import com.goat.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: Trigger 接口触发器
 * @date 2018/11/26---13:52
 */
public class JobScheduler {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("jobName", "jobGroup")  //定义job的名字和组
                .usingJobData("name", "yanjun")  //传参数，key:name value:yanjun
                .usingJobData("age", 18)  //传参数，key:age value:18
                .build();

        //定义开始时间
        Date startDate = new Date();
        //定义结束时间，在开始时间之后10秒
        Date endDate = new Date(startDate.getTime() + 10 * 1000);
        //触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "triggerGroup")
                .startNow()  //现在开始执行
                .startAt(startDate)  //在指定的时间开始执行
                .endAt(endDate)      //在指定的时间结束执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .repeatForever()  //永远执行下去
                        .withRepeatCount(10)  //执行10次
                        .withIntervalInSeconds(1))  //一秒钟执行一次
                .build();

            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start(); //开始执行
    }
}
