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
    public void ac(){
        System.out.println(blogProperties);
    }

    /*
    Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
    想让Spring的配置文件生效，加载进来；@ImportResource(locations = {"classpath:beans.xml"}) 标注在启动类上
    * */
    @Test
    public void blogProperties(){
        System.out.println(ac.containsBean("testoService"));
    }
    @Test
    public void helloService(){
        System.out.println(ac.containsBean("helloService02"));
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
