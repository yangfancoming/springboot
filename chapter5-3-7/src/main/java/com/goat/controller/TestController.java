package com.goat.controller;


import com.goat.entity.User;
import com.goat.service.ITestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;


@RestController
public class TestController {

    /**
     *  声明需要调用的远程接口，生成远程服务代理类
     *  这里注入的是接口！ 将 service 的接口声明 与 具体实现  进行拆分！
     *  doit 这里在没有启动提供者服务的情况下，也可以正常启动？ 为啥 启动时检查 无效？？ 在没有服务提供者的情况下 消费者项目启动应该是报错的才对啊？
    */
    @Reference(timeout = 2000)
    public ITestService iTestService;

    // http://localhost:8537/sayHello/1
    @RequestMapping("/sayHello/{name}")
    public void hello(@PathVariable("name") String name) {
       User map =  iTestService.sayHello(Integer.valueOf(name));
        System.out.println(map);
    }

    /**
     * http://localhost:8537/sayHello/testTimeOut
     * 提供者 sleep 1 秒  超时报错： com.alibaba.dubbo.remoting.TimeoutException
     * 提供者 sleep 0.5 秒  可以正常访问  推出 dubbo 默认超时是1秒
     * 解决方法：配置超时时间     @Reference(timeout = 2000)
    */
    @RequestMapping("/sayHello/testTimeOut")
    public void testTimeOut() {
        String s = iTestService.testTimeOut();
        System.out.println(s);
    }

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("/sayHello")
    public String test() {
        String temp =  iTestService.testHystrix();
        System.out.println(temp);
        return temp;
    }

    public String hiError() {
        return "hi,"+",sorry,error!";
    }
}
