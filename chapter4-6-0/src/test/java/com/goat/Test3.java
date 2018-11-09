package com.goat;


import com.goat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test3 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired private UserService userService;



    @Test
    public void getAllUsers() {
        Integer count =  userService.getAllUsers();
        System.out.println(count);
    }
    @Test
    public void test() { // doit  这里返回0个  但是在 控制台执行该sql返回6个正确的，但是又在 database 表格中 查看 却又是0个 ？ 应该是授权问题？
        Integer temp = jdbcTemplate.queryForObject("select count(1) from STUDENT", Integer.class);
        System.out.println(temp);
    }


}
