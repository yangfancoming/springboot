package com.goat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/1/23.
 *
 * @ Description: 测试专用 controller
 * @ author  山羊来了
 * @ date 2019/1/23---14:46
 */
@RestController
public class TestController {

    @Autowired private ApplicationContext ac;

    // http://localhost:8539/test
    @GetMapping("test")
    public void test(){
        System.out.println(ac.containsBean("testoService"));
    }

    // http://localhost:8539/test1
    @GetMapping("test1")
    public void test1() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }
}
