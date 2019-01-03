package com.goat.config;

import com.goat.entity.SpringJobFactory;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by 64274 on 2018/8/24.
 *
 * @ author 山羊来了
 * @ Description: TODO
 * @date 2018/8/24---12:56
这里我们需要注意 我注入了一个 自定义的JobFactory ，然后 把其设置为SchedulerFactoryBean 的 JobFactory。
其目的是因为我在具体的Job 中 需要Spring 注入一些Service。
所以我们要自定义一个 JobFactory ， 让其在具体job 类实例化时 使用Spring 的API 来进行依赖注入。
 */
@Configuration
public class QuartzConfig {
    @Autowired
    private SpringJobFactory springJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springJobFactory);
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}