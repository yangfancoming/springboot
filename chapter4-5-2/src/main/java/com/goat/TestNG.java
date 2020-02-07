package com.goat;


import com.goat.chapter001.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;


/**
 * Created by 64274 on 2018/7/27.
 *
 */

public class TestNG   {

    @Autowired
    private ApplicationContext ac;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    @Test
    public void test1() {
        User user = new User();
        user.setId("33");
        user.setName("goat");
        mongoTemplate.save(user);
    }


}
