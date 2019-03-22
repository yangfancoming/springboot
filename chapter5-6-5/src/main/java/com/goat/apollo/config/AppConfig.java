package com.goat.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/3/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/22---10:55
 */
@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public RefreshConfig refreshConfig(){
        return new RefreshConfig();
    }
}