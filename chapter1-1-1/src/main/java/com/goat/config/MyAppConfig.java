package com.goat.config;

import com.goat.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2018/11/30.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/30---13:18
 */

@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；容器中这个组件默认的id就是 sos 方法名
    @Bean
    public HelloService helloService02(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
