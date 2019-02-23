package com.goat.config;

import com.goat.bean2.Dog;
import com.goat.bean2.Person;
import com.goat.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by 64274 on 2018/11/30.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/30---13:18
 */

@Configuration
public class MyAppConfig {

    @Bean
    @Profile({"dev","test"})// 只有在 两大属性文件中 找到 spring.profiles.active=dev 相匹配则创建该bean ，若 spring.profiles.active=pro 则不创建
    //    @ConditionalOnProperty(name = "PROFILE", havingValue = "dev", matchIfMissing = false)
    public HelloService helloService02(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }


    @Bean  // 给容器中注册一个bean！ 其类型为返回值类型，id 默认为函数名 自定义bean名称(bean id)： @Bean("beanName")
    public Person person01(){
        return new Person("goat",123);
    }

    /**  相当于传统方式 ：
     <bean id="Dog01" class="com.goat.bean2.Dog">
         <property name="lastName" value="halala"></property>
         <property name="age" value="111"></property>
     </bean>
     */
    @Bean
    public Dog dog03(){
        return new Dog("halala",111);
    }

    /**
     @ConditionalOnProperty(name = "PROFILE", havingValue = "dev", matchIfMissing = true)
     这个注解能够控制某个configuration是否生效。具体操作是通过其两个属性name以及havingValue来实现的，
     其中name用来从application.properties中读取某个属性值，如果该值为空，则返回false;
     如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。
     如果返回值为false，则该configuration不生效；为true则生效。
     */
}
