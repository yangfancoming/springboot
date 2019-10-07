package com.goat.chapter404;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/10/7.
 *
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
    @RequestMapping("/test1")
    public void hellola(){
        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList("select * from book ");
        System.out.println(maps1);
    }

}
