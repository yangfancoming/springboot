package com.goat.condition2;

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
public class ConditionConfig2 {

    @Bean
    @Conditional(ManCondition.class)
    //如果ManCondition中的match方法返回结果true，就创建该Bean,否则不创建
    public Man getMan(){
        return new Man();
    }

    @Bean
    @Conditional(WomanCondition.class)
    public Woman getWoman(){
        return new Woman();
    }

}