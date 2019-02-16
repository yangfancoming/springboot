package com.goat.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/2/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/16---10:43
 */
@Configuration
public class PersonConfig {

    @Bean("goat")
    @Conditional(LinuxCondition.class) // 条件判断 true 则创建该bean  false 则不会创建该bean
    public Person person1() {
        return new Person("goat",17);
    }

    @Bean("jordan")
    @Conditional(WindowsCondition.class) // 条件判断 true 则创建该bean  false 则不会创建该bean
    public Person person2() {
        return new Person("jordan",23);
    }
}
