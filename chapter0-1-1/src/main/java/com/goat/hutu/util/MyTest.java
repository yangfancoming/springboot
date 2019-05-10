package com.goat.hutu.util;


import cn.hutool.core.date.DateTime;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    public void log4jAndSlf4jTest() {
        //slf4+log4j “传统”日志
        logger.info("当前毫秒: {},对应秒数为{}", System.currentTimeMillis(), System.currentTimeMillis() / 1000);
        Exception e = new NullPointerException();
        //logger.error(e,"空指针异常,发生时间：","now"); 无法这样使用
        logger.error("空指针异常", e);
    }

    @Test
    public void test() {
        log4jAndSlf4jTest();
    }


    private static final Log log = LogFactory.get();

    public void hutoolLogTest(){
        //Log+log4j “糊涂”日志
        log.info("当前时间：{}", DateTime.now());
        Exception e = new NullPointerException();
        log.error(e,"空指针异常，类型{}",e.getClass());
    }

    @Test
    public void test1(){
        hutoolLogTest();
    }
}
