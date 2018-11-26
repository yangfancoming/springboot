package com.goat.job;

import org.quartz.*;

import java.util.Date;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: 新建任务类  实现Job 接口  重写 execute() 方法
 * @date 2018/11/26---11:08
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务执行了: ");

        JobDataMap dataMap = context.getMergedJobDataMap();
        String name = dataMap.getString("name");  //获取名字
        Integer age = dataMap.getInt("age");    //获取年龄

        System.out.println("name: " + name + "  age:" + age);

        JobDetail jobDetail = context.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String jobGroup = jobDetail.getKey().getGroup();

        System.out.println("jobName: " + jobName + "  jobGroup:" + jobGroup);

        Trigger trigger = context.getTrigger();
        String triggerName = trigger.getKey().getName();
        String triggerGroup = trigger.getKey().getGroup();
        Date startTime = trigger.getStartTime();  //获取任务开始时间
        Date endTime = trigger.getEndTime();    //获取任务结束时间

        System.out.println("triggerName: " + triggerName + "  triggerGroup:" + triggerGroup);
        System.out.println("startTime: " + startTime + "  endTime:" + endTime);

    }
}
