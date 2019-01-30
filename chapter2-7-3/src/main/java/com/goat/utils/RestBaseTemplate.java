package com.goat.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/1/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/30---10:35
 */
public class RestBaseTemplate extends RestTemplate {

    public RestBaseTemplate() {
        super();
    }

    public RestBaseTemplate(ClientHttpRequestFactory factory) {
        super(factory);
    }

    /**
     *  通用请求接口
     *
     * @param url 请求 URL
     * @param params 请求参数
     * @param responseType 返回类型
     * @param method 请求方式，使用 HttpMethod，默认为 HttpMethod.POST
     * @return 响应的 body 内容
     */
    public <T> T restTemplate(String url, Map<String, Object> params, Class<T> responseType, HttpMethod method) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        if (params != null) {
            map.setAll(params);
        }
        switch (method) {
            case POST:
                return this.postForObject(url, map, responseType);
            case GET:
                String getParams;
                if (params == null) {
                    getParams = url;
                } else {
                    getParams = "?" + map.keySet().stream().map(k -> String.format("%s={%s}", k, k))
                            .collect(Collectors.joining("&"));
                }
                return this.getForObject(url + getParams, responseType, params);
            default:
                return this.postForObject(url, map, responseType);
        }
    }

    /**
     * GET 请求，不带参数
     * @param url 请求的URL
     * @return 响应的 body 内容
     */
    public String get(String url) {
        return get(url, new HashMap<>(1));
    }

    /**
     * GET 请求，带参数
     * @param url 请求的URL
     * @param params 请求的参数，不需要做 Encode 处理
     * @return 响应的 body 内容
     */
    public String get(String url, Map<String, Object> params) {
        return restTemplate(url, params, String.class, HttpMethod.GET);
    }

    /**
     * POST 请求，限制返回类型为字符串
     * @param url 请求的 URL
     * @param params 请求参数
     * @return 响应的 body 内容
     */
    public String post(String url, Map<String, Object> params) {
        return restTemplate(url, params, String.class, HttpMethod.POST);
    }

    /**
     * POST 请求
     * @param url 请求的 URL
     * @param params 请求参数
     * @param responseType 返回的数据格式
     * @return 响应的 body 内容
     */
    public <T> T post(String url, Map<String, Object> params, Class<T> responseType) {
        return restTemplate(url, params, responseType, HttpMethod.POST);
    }
}
