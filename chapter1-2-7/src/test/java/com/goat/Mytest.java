package com.goat;

import com.goat.condition.Person;
import com.goat.condition.ListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by 64274 on 2019/2/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/16---10:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {



    @Autowired private ApplicationContext ac;

    /**
     * 使用 AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
     * 会报错 has not been refreshed yet
     */
    @Test
    public void test1(){
        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for(String temp : beanNamesForType){
            System.out.println(temp);
        }

        Map<String, Person> beansOfType = ac.getBeansOfType(Person.class);
        System.out.println(beansOfType); // key beanId  value 是我们注入容器的对象
    }
    @Test
    public void test2(){ // 测试结果  是 windows 系统 容器创建 jordan 和 WindowsListService 这两个bean
        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for(String temp : beanNamesForType){
            System.out.println(temp);
        }

        Map<String, ListService> beansOfType = ac.getBeansOfType(ListService.class);
        System.out.println(beansOfType); // key beanId  value 是我们注入容器的对象
    }
}
