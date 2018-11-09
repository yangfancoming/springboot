package com.goat;


import com.goat.domain.p.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {


    //  JdbcTemplate 测试

    @Autowired
    private UserDao userDao;

    @Test
    public void create() {
        userDao.create("test",111);
    }

}
