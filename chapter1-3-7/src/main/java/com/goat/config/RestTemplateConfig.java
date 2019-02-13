package com.goat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * HTTP 封装类
 */
@Configuration
public class RestTemplateConfig {

    @Value("${remote.maxTotalConnect:20}")//连接池的最大连接数默认为20
    private int maxTotalConnect;
    @Value("${remote.maxConnectPerRoute:20}")//单个主机的最大连接数
    private int maxConnectPerRoute;
    @Value("${remote.connectTimeout:5000}")//连接超时默认2s
    private int connectTimeout;
    @Value("${remote.readTimeout:5000}")//读取超时默认30s
    private int readTimeout;

    /**
     *
     Spring Boot >= 1.4
     Spring Boot no longer automatically defines a RestTemplate but instead defines a RestTemplateBuilder allowing you more control over the RestTemplate that gets created.
     You can inject the RestTemplateBuilder as an argument in your @Bean method to create a RestTemplate:
     定义了 该bean后 即可在类中 使用     @Autowired RestTemplate restTemplate;
    */
    @Bean  // 初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
    @ConditionalOnMissingBean({ RestOperations.class, RestTemplate.class })
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

    /**配置超时时间*/
    @Bean
    @ConditionalOnMissingBean({ClientHttpRequestFactory.class})
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(connectTimeout);//单位为ms
        factory.setReadTimeout(readTimeout);//单位为ms
        return factory;
    }

}
