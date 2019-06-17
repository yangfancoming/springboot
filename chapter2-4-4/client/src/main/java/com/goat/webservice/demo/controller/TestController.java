package com.goat.webservice.demo.controller;

import com.goat.webservice.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/6/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/17---14:39
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AppService appService;

    /**  http://localhost:8241/test/test1
     * Springboot 调用 C# .net 提供的webservice 的asmx 后缀 服务 方式
     *
     *         JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
     *         Client client = dcf.createClient("http://localhost:1126/WebService.asmx?WSDL"); // 这里最后必须加  ?WSDL  ！！！
     *         Object[] res = client.invoke("HelloWorld", 1,2);// 方法名  后面是可变参数
     *         System.out.println("HelloWorld response: " + res[0]);
     */
    @GetMapping("/test1")
    public void fuck(){
        Object test = appService.fuck(1, 3);
        System.out.println(test);
    }

}
