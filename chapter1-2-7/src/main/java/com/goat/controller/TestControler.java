package com.goat.controller;


import com.goat.condition.ConditionConfig;
import com.goat.condition.ListService;
import com.goat.condition2.ConditionConfig2;
import com.goat.condition2.Person;
import com.goat.condition3.I18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired private ApplicationContext ac;
    @Autowired ListService listService;


    //    http://localhost:8127/test0
    @RequestMapping(value = "/test0")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

//    http://localhost:8127/test1
    @RequestMapping(value = "/test1")
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为:" + listService.showListCmd());
    }

    //    http://localhost:8127/test2
    @RequestMapping(value = "/test2")
    public void test2(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig2.class);
        Person person = ctx.getBean(Person.class);
        //通过条件类判断，只有Woman的条件类返回true，所以在容器中只能找到Woman的实现类的装载bean,而Woman又是继承自Person的，所以，在容器中可以找到一个唯一的Bean,通过getBean获取到。
        System.out.println(person);
        person.birth();
    }

    //    http://localhost:8127/test3
//    @RequestMapping(value = "/test3")
//    public void test3(){
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
//        context.refresh();
//        I18n i18n = context.getBean(I18n.class);
//        System.out.println(i18n.getClass().getName());
//        System.out.println(i18n.i18n("lang"));
//    }
}




