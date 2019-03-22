package com.goat.apollo.controller;

import com.goat.apollo.config.JavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/22---10:57
 */
@RestController
public class TestController {

    @Autowired
    JavaConfigBean javaConfigBean;

    //  http://localhost:8565/test1
    @RequestMapping("/test1")
    public String hello1(){
        return javaConfigBean.getTimeout()+"";
    }
}