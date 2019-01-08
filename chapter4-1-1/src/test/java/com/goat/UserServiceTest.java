package com.goat;


import com.goat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private ApplicationContext ac;

    @Autowired private UserService userService;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    @Test
    public void getAllUsers() {
        Integer count =  userService.getAllUsers();
        System.out.println(count);
    }


    @Test
    public void test01() {


    }

    @Test
    public void test() {

    }
}
