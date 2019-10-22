package com.goat.chapter131;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 64274 on 2019/10/22.
 *
 * @ Description: 此处涉及到JUL的默认配置文件loging.properties,该配置文件位于jdk安装目录的lib包下
 * @ author  山羊来了
 * @ date 2019/10/22---11:00
 */
@RestController
public class TestController {

    /**
     * logger默认的级别是INFO，比INFO更低的日志将不显示
     · SEVERE（最高值）
     · WARNING
     · INFO
     · CONFIG
     · FINE
     · FINER
     · FINEST（最低值）
    */
    Logger logger = Logger.getLogger("goat");

    // http://localhost:8131/test1
    @GetMapping("/test1")
    public void test1(){
        // all→finest→finer→fine→config→info→warning→server→off
        // 级别依次升高，后面的日志级别会屏蔽之前的级别
        logger.setLevel(Level.ALL);
        logger.severe("severe ...");
        logger.warning("warning ...");
        logger.info("info ...");

        logger.config("config ...");
        logger.fine("fine ...");
        logger.finer("finer ...");
        logger.finest("finest ...");


    }


}
