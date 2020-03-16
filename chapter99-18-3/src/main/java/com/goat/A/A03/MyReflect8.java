package com.goat.A.A03;


import com.goat.model.Person;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 山羊来了
 * @Description: Java反射之getInterfaces()方法
 * @date 2019年12月5日15:42:26
 */
public class MyReflect8 {

    Person person = new Person();

    @Test
    public void test()  {
        person.Speak("小明");
        person.fly();
        person.swim();
    }

    // 遍历 类对象 实现的所有接口
    @Test
    public void test1()  {
        Class<?>[] interfaces = Person.class.getInterfaces();
        Arrays.stream(interfaces).forEach(x->System.out.println(x.getName()));
    }

    // 遍历 类对象 实现的所有接口中的方法
    @Test
    public void test2()  {
        Class<?>[] interfaces = person.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(x->{
            Method[] methods = x.getMethods();
            Arrays.stream(methods).forEach(y->System.out.println(y.getName()));
        });
    }

}
