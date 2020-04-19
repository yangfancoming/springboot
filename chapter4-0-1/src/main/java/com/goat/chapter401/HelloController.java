package com.goat.chapter401;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * Created by Administrator on 2020/4/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/4/19---11:39
 */
@RestController
public class HelloController {

    @GetMapping
    public void test() throws ClassNotFoundException {
        Properties prop = new Properties();
        prop.put("charSet", "gb2312"); // 这里是解决中文乱码
        prop.put("user", "");
        prop.put("password", "");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        Connection conn = DriverManager.getConnection("",prop);
    }
}
