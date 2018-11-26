package com.goat.controller;


import com.goat.job.BaseJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/job")
public class JobController 
{
//	@Autowired
//	private IJobAndTriggerService iJobAndTriggerService;
	
	//加入Qulifier注解，通过名称注入bean
	@Autowired
    @Qualifier("Scheduler")
	private Scheduler scheduler;
	

	/**
	     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
	     * @author: 杨帆
         * @param jobClassName  com.goat.job.HelloJob   这里必须是 全限定类名
         * @param jobGroupName  组名 可以随意填写
         * @param cronExpression  cron 表达式 0/1 * * * * ?
	     * @Return:
	     * @Date:   2018/11/26
	*/
	@PostMapping(value="/addjob")
	public void addjob(@RequestParam(value="jobClassName")String jobClassName,
			@RequestParam(value="jobGroupName")String jobGroupName,
			@RequestParam(value="cronExpression")String cronExpression) throws Exception
	{			
		addJob(jobClassName, jobGroupName, cronExpression);
	}
	
	public void addJob(String jobClassName, String jobGroupName, String cronExpression)throws Exception{
        // 启动调度器
        scheduler.start();
        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobClassName, jobGroupName).build();
        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName) .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
	}


	@PostMapping(value="/pausejob")
	public void pausejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception {
		jobPause(jobClassName, jobGroupName);
	}
	
	public void jobPause(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
	}
	

	@PostMapping(value="/resumejob")
	public void resumejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception {
		jobresume(jobClassName, jobGroupName);
	}
	
	public void jobresume(String jobClassName, String jobGroupName) throws Exception {
		scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
	}
	
	
	@PostMapping(value="/reschedulejob")
	public void rescheduleJob(@RequestParam(value="jobClassName")String jobClassName,
			@RequestParam(value="jobGroupName")String jobGroupName,
			@RequestParam(value="cronExpression")String cronExpression) throws Exception
	{			
		jobreschedule(jobClassName, jobGroupName, cronExpression);
	}
	
	public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(triggerKey, trigger);
	}

	
	@PostMapping(value="/deletejob")
	public void deletejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception {
		jobdelete(jobClassName, jobGroupName);
	}
	
	public void jobdelete(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));				
	}


	public static BaseJob getClass(String classname) throws Exception {
		Class<?> class1 = Class.forName(classname);
		return (BaseJob)class1.newInstance();
	}
	
	
}
