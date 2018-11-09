package com.goat;


import com.goat.config.AliyunOssConfig;
import com.goat.config.JwtConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired private ApplicationContext ac;
    @Autowired private AliyunOssConfig aliyunOssConfig;
    @Autowired private JwtConfig jwtConfig;


    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }
    @Test
    public void dataSource() {
        System.out.println(ac.containsBean("dataSource"));
    }
    @Test
    public void corsFilter() {
        System.out.println(ac.containsBean("corsFilter"));
    }
    @Test
    public void controllerApi() {
        System.out.println(ac.containsBean("controllerApi"));
    }
    @Test
    public void test3() {
        System.out.println(aliyunOssConfig);
    }

    @Test
    public void jwtSettings() {
        System.out.println(jwtConfig);
    }
}
