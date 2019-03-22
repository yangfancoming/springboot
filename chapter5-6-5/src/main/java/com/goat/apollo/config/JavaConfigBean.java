package com.goat.apollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/3/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/22---10:58
 */
@Configuration
public class JavaConfigBean {

    @Value("${timeout:20}")
    private int timeout;

    public int getTimeout() {
        return timeout;
    }
}