package com.goat;


import com.goat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;



/**
 * Created by 64274 on 2018/7/27.
 *
 */
@ContextConfiguration(classes= Application.class)
public class TestNG extends AbstractTestNGSpringContextTests {

    @Autowired private ApplicationContext ac;

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

}
