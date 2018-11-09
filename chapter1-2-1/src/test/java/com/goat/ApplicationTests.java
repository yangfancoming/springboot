package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired private ApplicationContext ac;

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }
    @Test
    public void test() {
        // 日志级别： 由低到高
        logger.trace("这是  trace.................");
        logger.debug("这是  debug.................");
        // springboot 默认设置输出的日志级别 为 info级别  因此 控制台只输出 info及更高级别的日志输出
        logger.info("这是  info.................");
        logger.warn("这是  warn.................");
        logger.error("这是  error.................");
    }

}
