package com.goat;

import com.goat.bean.User;
import com.goat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    UserService userService;


    @Test
    public void test(){
        User user = userService.findUser("goat");
        System.out.println(user);
    }


    @Test
    public void removeUser(){
        userService.removeUser("goat");
    }


}
