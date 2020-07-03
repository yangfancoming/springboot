package com.goat.chapter404;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/10/7.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/7---19:15
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 测试地址： http://localhost:8404/hello/test1
    @GetMapping("/test1")
    public void hellola(){
        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList("select * from book ");
        System.out.println(maps1);
    }

    @Resource
    private DataSource dataSource;

    // 测试地址： http://localhost:8404/hello/query
    @GetMapping("/query")
    public void query(){
        System.out.println("查询到的数据源连接池信息是:"+dataSource);
        System.out.println("查询到的数据源连接池类型是:"+dataSource.getClass());
//        System.out.println("查询到的数据源连接池名字是:"+dataSource.getp().getName());
    }
}
