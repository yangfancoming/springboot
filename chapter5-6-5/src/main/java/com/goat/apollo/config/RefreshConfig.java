package com.goat.apollo.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by 64274 on 2019/3/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/22---10:56
 */
public class RefreshConfig {
    @ApolloConfig
    //inject config for namespace application
    private Config config;

    @ApolloConfig("application")
    private Config anotherConfig;

    @Value("${timeout}")
    private String timeout;

    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        //update injected value of batch if it is changed in Apollo
        if (changeEvent.isChanged("timeout")) {
            timeout = config.getProperty("timeout","100");
            System.out.println("哥在监听的哦");
        }
    }

}