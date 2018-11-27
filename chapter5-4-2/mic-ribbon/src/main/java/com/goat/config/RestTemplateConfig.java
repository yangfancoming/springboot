package com.goat.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 64274 on 2018/11/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/27---13:45
 */
@Configuration
public class RestTemplateConfig {

    @Bean // 将 RestTemplate 模板 注入到bean容器里面去
    @LoadBalanced // 将 支持负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}