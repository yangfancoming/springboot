package com.goat.chapter130;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/9/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/10---14:16
 */

@RestController
@RequestMapping("log4j2")
public class Log4j2Controller {

    private static final Logger log = LoggerFactory.getLogger(Log4j2Controller.class);

    // http://localhost:8130/log4j2/test1
    @GetMapping("test1")
    public void test1(){
        for (int i = 0; i < 100*1000; i++) {
            log.error("我是error"+ i);
            log.warn("我是warn"+ i);
            log.info("我是info"+ i);
            log.debug("我是debug"+ i);
        }
    }

    // http://localhost:8130/log4j2/test2
    @GetMapping("test2")
    public void test2(){
        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");
    }

}
