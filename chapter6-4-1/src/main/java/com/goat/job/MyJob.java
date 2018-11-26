package com.goat.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: 新建任务类  实现Job 接口  重写 execute() 方法
 * @date 2018/11/26---11:08
 */
public class MyJob implements Job {

    // 任务的构造方法  每次都会被调用
    public MyJob() {
        System.out.println("我是任务的构造方法。。。。。。。");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println("正在操作数据库。。。。。。。。。。"+format);

    }
}
