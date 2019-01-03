package com.goat;


import com.goat.entity.User;
import com.goat.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {

    @Autowired private UserDao userDao;


    @Test
    public void test() {
        List<User> userList =  userDao.findList();
        System.out.println(userList);
    }

}
