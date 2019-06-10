package com.goat.service;


import com.goat.fallback.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
     * @Description:  feign 调用 其他项目微服务
     * @author: Goat
     * @param : goat2234234234 为  microservice-hi 项目配置文件中的 spring.application.name 属性
     * @param : /hi  为             microservice-hi 项目 HiController 中 映射的 请求url
       sos  对比 ribbon  return restTemplate.getForObject("http://goat2234234234/hi",String.class);
     * @Date:   2018/11/27
*/
@FeignClient(value = "goat2234234234",fallback = SchedualServiceHiHystric.class) // 服务名
public interface TestService {
    @RequestMapping(value = "/hi") // 请求url
    String testFuck();
}
