package com.goat.controller;


import com.goat.service.HelloService;
import com.goat.service.TestService;
import com.goat.service.TestService2;
import com.goat.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;


@RestController
@RequestMapping("/testbean")
public class TestBean {

    @Autowired private ApplicationContext ac;
    @Autowired private TestService testService;
    @Autowired private TestService2 testService2;
    @Autowired private HelloService helloService;

    //    http://localhost:1111/test0
    @GetMapping("/test0")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    /**
     http://localhost:1111/testbean/test2
     通过启动类 @ImportResource(locations = {"classpath:beans.xml"}) 注解  注入 该bean
    */
    @GetMapping("/test2")
    public void test2(){
        testService.test();
    }

    /**
     http://localhost:1111/testbean/test2
     通过@Service 注解 注入该 bean
     */
    @GetMapping("/test3")
    public void test3(){
        testService2.test();
    }

    /**  sos 实测 该方法  可以在拦截器中 注入 bean
     http://localhost:1111/testbean/test4
     通过启动类 FileSystemXmlApplicationContext  加载 该bean
     FileSystemXmlApplicationContext("beans.xml") 这种路径 虽然鼠标可以点击导航 但路径是不正确的 会报错  java.io.FileNotFoundException: beans.xml
     */
    @GetMapping("/test4")
    public void test4(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:beans.xml");
        TestService testService = (TestService) ac.getBean("testoService");
        testService.test();
    }

    /** sos 实测 该方法  可以在拦截器中 注入 bean
     * http://localhost:1111/testbean/test5
     * 通过 implements ApplicationContextAware 获取 该bean
    */
    @GetMapping("/test5")
    public void test5(){
        TestService testoService1 = (TestService) SpringContextUtil.getBean("testoService");
        TestService testoService2 = (TestService) SpringContextUtil.getBean("testoService");
        assertThat(testoService1, sameInstance(testoService2)); // 判断两个对象 是否是同一个实例
        testoService1.test();
    }

    /**
     http://localhost:1111/testbean/test6
     通过 MyAppConfig 类的  @Configuration 和 @Bean 注解 注入该bean
     */
    @GetMapping("/test6")
    public void test6(){
        helloService.hello();
    }


}



