package com.goat;


import com.goat.domain.p.UserDao;
import com.goat.domain.s.MessageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {


    // 向 core1 数据库 插入 数据

    @Autowired
    private UserDao userDao;

    @Test
    public void create() {
        userDao.create("test",111);
    }


    // 向 core2 数据库 插入 数据
    @Autowired
    private MessageDao messageDao;

    @Test
    public void save() {
        messageDao.create("test","1111111111");
    }
}
