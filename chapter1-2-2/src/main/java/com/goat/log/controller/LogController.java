package com.goat.log.controller;

import com.alibaba.fastjson.JSON;
import com.goat.log.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/4/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/3---13:08
 */
@RestController
public class LogController {


    private Logger logger = LoggerFactory.getLogger(getClass());

//    private static final Logger LOG = LoggerFactory.getLogger(LogController.class);
//    private  final Logger logger = LoggerFactory.getLogger(getClass());
    //  http://localhost:8122/test
    @GetMapping("/test")
    public void test(){
        logger.info("==========print log==========");
    }

    //  http://localhost:8122/test1

    /**
     springboot 默认设置输出的日志级别 为 info 级别  因此 控制台只输出 info 及更高级别的日志输出
     更改默认日志打印级别： 在配置文件中 打开 logging.level.com.goat.log = trace 注释 可以看到 所有日志 全部输入
    */
    @GetMapping("/test1")
    public void test1(){
        // 日志级别： 由低到高
        logger.trace("这是  trace.................");
        logger.debug("这是  debug.................");
        logger.info("这是  info.................");
        logger.warn("这是  warn.................");
        logger.error("这是  error.................");
    }

    //  http://localhost:8122/test2
    @GetMapping("/test2")
    public void test2(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("11",11));
        userList.add(new User("22",22));

        String json = JSON.toJSONString(userList);

        logger.error("这是  error................{}.",json);
        logger.info("123..............{}.",111);
        logger.info("username:{}  and pwd:{}", 11, 22);
    }
}
