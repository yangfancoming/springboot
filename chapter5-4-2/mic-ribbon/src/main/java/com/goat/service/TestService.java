package com.goat.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    /**
         * @Description:  调用其他项目提供的微服务   （这里调用 microservice-hi 项目的 http://localhost:8111/hi  服务  ）
         * @author: Goat
         * @param : goat2234234234 为  microservice-hi 项目配置文件中的 spring.application.name 属性
         * @param : /hi  为             microservice-hi 项目 HiController 中 映射的 请求url
         * @Return:
         * @Date:   2018/11/27
    */

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService() {
        return restTemplate.getForObject("http://goat2234234234/hi",String.class);
    }
/**
 fallback method wasn't found: hiError([])] with root cause 报错原因： sos 熔断方法 和 请求服务方法 的参数个数，类型不同造成的；
 public String hiError(String name) {
 return "hi,"+name+",sorry,error!";
 }

 sos 熔断方法 和 请求服务方法的 返回值类型不同 造成的！
 Hint: Fallback method 'public void com.goat.controller.ApiController.hiError()' must return: class java.lang.String or its subclass] with root cause
 public void hiError(String name) {
 return "hi,"+name+",sorry,error!";
 }

 sos ：总结 熔断方法和 请求方法 参数类型和个数 还有 返回值类型 必须都要相同！！！
*/

    public String hiError() {
        return "hi,"+",sorry,error!";
    }
}
