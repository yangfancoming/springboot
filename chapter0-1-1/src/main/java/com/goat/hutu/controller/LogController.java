package com.goat.hutu.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**  Hutool 日志 1.可以直接使用.get() 不再需要写类名 2.对于附带Exception参数的方法，支持变量使用变量模式 */
    private static final Log log = LogFactory.get();

    //  http://localhost:8011/test
    @GetMapping("/test")
    public void test(){
        log.trace("trace：{}", DateTime.now());
        log.info("info：{}", DateTime.now());
        log.error("error：{}", DateTime.now());
        Exception e = new NullPointerException();
        log.error(e,"空指针异常，类型{}",e.getClass()); // 使用变量模式
    }


    /**  slf4j 日志  对于附带Exception参数的方法，不支持变量使用变量模式   */
//    private static final Logger logger = LoggerFactory.getLogger(LogController.class); // static 的原因
    private  final Logger logger = LoggerFactory.getLogger(getClass());

    //  http://localhost:8011/test1
    @GetMapping("/test1")
    public void test1(){
        logger.info("当前时间：{}", DateTime.now());
        logger.trace("这是  trace.................");
        logger.debug("这是  debug.................");
        logger.info("这是  info.................");
        logger.error("这是  error.................");
//        Exception e = new NullPointerException();
//        logger.error(e,"空指针异常，类型{}",e.getClass()); // 使用 slf4j 日志 不支持这种语句 会报错！
    }
}
