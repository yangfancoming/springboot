package com.goat.dynamicTask;

import com.goat.job.MyJob1;
import com.goat.job.MyJob2;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---16:08
 */
@Component
public class MyDynamicConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedRateTask(new MyJob1(6),5*1000);
        taskRegistrar.addFixedRateTask(new MyJob2(7),5*1000);
    }
}
