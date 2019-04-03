package com.goat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/4/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/3---13:08
 */
@RestController
public class LogController {

//    private static final Logger LOG = LoggerFactory.getLogger(LogController.class);
    private  final Logger logger = LoggerFactory.getLogger(getClass());
    //  http://localhost:8121/test
    @GetMapping("/test")
    public void test(){
        logger.info("==========print log==========");
    }

    //  http://localhost:8121/test1
    @GetMapping("/test1")
    public void test1(){
        // 日志级别： 由低到高
        logger.trace("这是  trace.................");
        logger.debug("这是  debug.................");
        // springboot 默认设置输出的日志级别 为 info级别  因此 控制台只输出 info及更高级别的日志输出
        logger.info("这是  info.................");
        logger.warn("这是  warn.................");
        logger.error("这是  error.................");
    }
}
