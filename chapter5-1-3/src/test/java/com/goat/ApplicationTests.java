package com.goat;

import com.goat.entity.User;
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
    public void test2(){
        User user = userService.findUser2("goat");
        System.out.println(user);
    }

    @Test
    public void clearAll(){
        userService.clearAll();
    }
    @Test
    public void removeUser(){
        userService.removeUser("goat");
    }

    @Test
    public void save(){
        userService.save(321,"goat");
    }
    @Test
    public void condition(){
        userService.condition("32"); // 满足条件  插入缓存
        userService.condition("33"); // 不满足条件 不会保存到缓存
    }
    @Test
    public void unless(){
        userService.unless("33"); // 不满足条件 插入缓存
//        userService.unless("32"); //  满足条件  不会保存到缓存
    }

    @Test
    public void booksAll(){
        userService.booksAll("321");
    }

}
