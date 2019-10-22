package com.goat.chapter131;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.*;

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

    // http://localhost:8131/test2
    @GetMapping("/test2")
    public void test2(){
        //输出到本地文件
        FileHandler handler = null;
        try {
            handler = new FileHandler("E://TestsLog",1000000,10,true);// 将日志消息转发给期望的输出,这里输出到文件；
        } catch (IOException e) {
            logger.severe("文件夹不存在");
        }
        tet(handler);
    }

    // http://localhost:8131/test3
    @GetMapping("/test3")
    public void test3(){
        //输出到本地文件
        SocketHandler handler = null;
        //输出到远程
        try {
            handler = new SocketHandler("localhost", 8080);
        } catch (IOException e) {
            logger.severe("请检查地址和端口是否正确......");
        }

        tet(handler);
    }

    public void tet(StreamHandler handler) {
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);//设置记录的级别
        SimpleFormatter formatter = new SimpleFormatter();//格式化;还可以用XMLFormatter
        handler.setFormatter(formatter);
        logger.warning("代码有问题");//添加记录
    }
}
