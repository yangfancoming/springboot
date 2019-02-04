package com.goat.config;

/**
 * Created by 64274 on 2019/1/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/30---10:36
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

/**
 * HTTP 封装类
 */
@Configuration
@ConditionalOnClass(value = {RestTemplate.class, HttpClient.class})
public class RestTemplateConfiguration {

    @Value("${remote.maxTotalConnect:20}")//连接池的最大连接数默认为20
    private int maxTotalConnect;
    @Value("${remote.maxConnectPerRoute:200}")//单个主机的最大连接数
    private int maxConnectPerRoute;
    @Value("${remote.connectTimeout:2000}")//连接超时默认2s
    private int connectTimeout;
    @Value("${remote.readTimeout:10000}")//读取超时默认30s
    private int readTimeout;

    //创建HTTP客户端工厂
//    private ClientHttpRequestFactory createFactory() {
//        if (this.maxTotalConnect <= 0) {
//            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//            factory.setConnectTimeout(this.connectTimeout);
//            factory.setReadTimeout(this.readTimeout);
//            return factory;
//        }
//        HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(this.maxTotalConnect)
//                .setMaxConnPerRoute(this.maxConnectPerRoute).build();
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory( httpClient);
//        factory.setConnectTimeout(this.connectTimeout);
//        factory.setReadTimeout(this.readTimeout);
//        return factory;
//    }

    /**
     * 初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
     */
//    @Bean("restBaseTemplate")
//    public RestBaseTemplate getRestTemplate() {
//        RestBaseTemplate restBaseTemplate = new RestBaseTemplate(this.createFactory());
//        List<HttpMessageConverter<?>> converterList = restBaseTemplate.getMessageConverters();
//        //加入FastJson转换器
//        converterList.add(new FastJsonHttpMessageConverter());
//        return restBaseTemplate;
//    }
}
