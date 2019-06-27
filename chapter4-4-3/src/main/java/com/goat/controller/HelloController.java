package com.goat.controller;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;


@RestController
@RequestMapping("/hello")
public class HelloController {


    //    http://localhost:8443/hello/test1
    @GetMapping("/test1")
    public void test1() throws Exception {
        Connection conn =getMySqlConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        Resources.setCharset(Charset.forName("UTF-8")); //设置字符集,不然中文乱码插入错误
        runner.setLogWriter(null);//设置是否输出日志
        // 绝对路径读取  sos  Reader read = new FileReader(new File("f:\\test.sql"));
        //
        // 从class目录下直接读取
        Reader read = Resources.getResourceAsReader("test.sql");
        runner.runScript(read);
        runner.closeConnection();
        conn.close();
        System.out.println("sql脚本执行完毕");
    }

    public static Connection getMySqlConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://172.16.163.135:3306/test2?Unicode=true&amp;characterEncoding=utf8&useSSL=false";
        return DriverManager.getConnection(url,"root","12345");
    }
}
