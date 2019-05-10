package com.goat.hutu.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/5/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/10---21:20
 */

@RestController
public class LogController {

    private static final Log log = LogFactory.get();

    //  http://localhost:8011/test
    @GetMapping("/test")
    public void test(){
        log.info("当前时间：{}", DateTime.now());
    }

}
