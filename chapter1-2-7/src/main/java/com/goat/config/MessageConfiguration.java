package com.goat.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageConfiguration {

    @Bean
    public String message() {
        return "message configuration";
    }


    /**
     * prefix application.properties配置的前缀
     * name 属性是从application.properties配置文件中读取属性值
     * havingValue 配置读取的属性值跟havingValue做比较，如果一样则返回true;否则返回false。
     * 如果返回值为false，则该configuration不生效；为true则生效
     * matchIfMissing = true表示如果没有在application.properties设置该属性，则默认为条件符合
     *
     * 是否启动jwt的配置，如果application.properties配置中没有设置就启动jwt，如果设置了true就启动，如果false就关闭
     * application.properties 配置如下
     *      rest:
     *      auth-open: true #jwt鉴权机制是否开启(true或者false)
    */
    @Bean
//    @ConditionalOnProperty(prefix = "rest", name = "auth-open", havingValue = "true", matchIfMissing = false)
//    @ConditionalOnProperty( name = "auth-open", havingValue = "true", matchIfMissing = false)  // doit ??? 该注解 放在方法上 为何无效？？？
    @ConditionalOnProperty(name = "yzh.conditional", havingValue = "true")
    public String foo() {
        return "foo configuration";
    }
}
