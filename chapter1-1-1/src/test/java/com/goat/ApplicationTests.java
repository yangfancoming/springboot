package com.goat;

import com.goat.bean.BlogProperties;
import com.goat.bean2.Person;
import com.goat.bean2.Pet;
import com.goat.bean2.Student;
import com.goat.bean3.Placeholder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // 相当于 配置文件中的 spring.profiles.active=test
public class ApplicationTests {

    @Autowired private ApplicationContext ac;

    @Autowired private BlogProperties blogProperties;

    @Autowired private Student student;
    @Autowired private Pet pet;
    @Autowired private Person person;
    @Autowired private Placeholder placeholder;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    @Test
    public void blogProperties(){
        System.out.println(blogProperties);
    }

    @Test
    public void student(){
        System.out.println(student);
    }

    @Test
    public void pet(){
        System.out.println(pet);
    }

    @Test
    public void person(){
        System.out.println(person);
    }
    @Test
    public void placeholder(){
        System.out.println(placeholder);
    }
}
