package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by 64274 on 2019/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/10---15:42
 */

@Configuration
public class MyConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
