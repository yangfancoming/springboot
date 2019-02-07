package com.goat.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: 新建任务类  实现Job 接口  重写 execute() 方法
 * @date 2018/11/26---11:08
 */
public class TestJob implements Job {

    // 任务的构造方法  每次都会被调用
    public TestJob() {
        System.out.println("我是任务的构造方法。。。。。。。");
    }

    @Override
    public void execute(JobExecutionContext context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println("正在操作数据库。。。。。。。。。。"+format);

        System.out.println("key"+ context.getJobDetail().getKey()); // 名称job1
        System.out.println("名称"+ context.getJobDetail().getKey().getName()); // 名称job1
        System.out.println("组名称"+ context.getJobDetail().getKey().getGroup()); // 组名称group1
        System.out.println("任务类"+ context.getJobDetail().getJobClass()); // 任务类class com.goat.job.TestJob

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("Instance of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);

    }
}
