package com.goat.config;

/**
 * Created by 64274 on 2019/1/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/30---10:36
 */

import com.goat.handler.CustomErrorHandler;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

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

    @Autowired CustomErrorHandler customErrorHandler;

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
        restTemplate.setErrorHandler(customErrorHandler); // 自定义异常处理
        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
        }
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
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

    /**配置http连接池*/

    @Bean
    public HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(poolingConnectionManager());//设置HTTP连接管理器
        return httpClientBuilder;
    }

    @Bean
    public HttpClientConnectionManager poolingConnectionManager() {

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(maxTotalConnect); // 连接池最大连接数
        connectionManager.setDefaultMaxPerRoute(maxConnectPerRoute); // 每个主机的并发
        return connectionManager;
    }



}
