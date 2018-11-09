package com.goat;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
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

    @Autowired
    private ApplicationContext ac;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }


    @Test
    public void testcallableCache()throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", ()->{
             String s = "hello " + "jerry" + "!";
             return s;
        });
        System.out.println("jerry value : " + resultVal);

        resultVal = cache.get("peida", ()->{
            String s = "hello " + "peida" + "!";
            return s;
        });
        System.out.println("peida value : " + resultVal);
    }



}
