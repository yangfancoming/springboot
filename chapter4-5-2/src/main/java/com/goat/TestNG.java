package com.goat;


import com.goat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;




/**
 * Created by 64274 on 2018/7/27.
 *
 */
@ContextConfiguration(classes= MongoTemplateApplication.class)

public class TestNG extends AbstractTestNGSpringContextTests {

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
        user.setName("fuck");
        mongoTemplate.save(user);
    }


}
