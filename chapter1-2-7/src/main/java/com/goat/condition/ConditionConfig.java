package com.goat.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/2/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/4---18:24
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }

}