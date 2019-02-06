package com.goat.dynamicTask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 64274 on 2019/2/7.
 *
 * @ Description: 动态定时任务
 * @ author  山羊来了
 * @ date 2019/2/7---0:49
 */
@Component
@EnableScheduling
public class DynamicScheduledConfig implements SchedulingConfigurer {

    // 默认每秒执行一次定时任务
    private String cron = "0/1 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        // 定时任务一：定时任务触发，可修改定时任务的执行周期
        taskRegistrar.addTriggerTask(()->{ // 此处执行定时任务的业务逻辑
            System.out.println("定时任务一，当前时间：" + new Date());
        }, triggerContext->{  // 定时任务触发，可修改定时任务的执行周期
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });

        // 定时任务四：此种不会因为cron的改变而改变任务执行时间
        taskRegistrar.addCronTask(new CronTask(()->System.out.println("定时任务四，当前时间：" + new Date()), new CronTrigger(this.getCron())));

        // 定时任务四：此种不会因为cron的改变而改变任务执行时间
        taskRegistrar.addCronTask(()->System.out.println("定时任务三，当前时间：" + new Date()), this.getCron());
    }


    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
