package com.goat.test;


import com.goat.Application;
import com.goat.bean.Person;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;


/**
     * @Description: 功能描述：
     * @author: 杨帆
　Guava Cache与ConcurrentMap很相似，但也不完全一样。最基本的区别是ConcurrentMap会一直保存所添加的元素，直到显式的移除；
  Guava Cache为了限制内存的占用，通常都是设定为自动回收元素。在某些场景下，尽管LoadingCahe不回收元素，但是它还是很有用的，因为它会自动加载缓存。
　Guava Cache适用场景：
你愿意消耗一部分内存来提升速度；
你已经预料某些值会被多次调用；
缓存数据不会超过内存总量；

　Guava Cache是一个全内存的本地缓存实现，它提供了线程安全的实现机制。整体上来说Guava cache 是本地缓存的不二之选，简单易用，性能好。


get 方法 简便地实现了模式"如果有缓存则返回；否则运算、缓存、然后返回"
put 方法 使用cache.put(key, value)方法可以直接向缓存中插入值

     * @Date:   2018/9/10
*/

@ContextConfiguration(classes= Application.class)
public class TestNG extends AbstractTestNGSpringContextTests {
    Person person = new Person();

    @BeforeMethod
    public void test(){
        person.setAge(11);
        person.setName("tSun");
    }

    @Test
    public void test1() throws ExecutionException { // 如果没有值,就执行其他方式去获取值
        System.out.println(CacheDemo.get("man"));
    }

    @Test
    public void test2() throws ExecutionException { // 缓存获取
        CacheDemo.put("man", new Person("hopg", 123));
        System.out.println(CacheDemo.get("man"));
    }


    @Test
    public void test3() throws ExecutionException { // 如果没有值,就执行其他方式去获取值
        System.out.println(CacheDemo.get("person").toString());
    }

    @Test
    public void test4() throws ExecutionException { // 缓存获取
        CacheDemo.put("person", person);
        System.out.println(CacheDemo.get("person").toString());
    }

    @Test
    public void test5() throws ExecutionException { // 如果没有值,就执行其他方式去获取值
        System.out.println(CacheDemo.get("woman"));
    }

    @Test
    public void test6() throws ExecutionException { // 缓存获取
        CacheDemo.put("women", new Person("google", 666));
        System.out.println(CacheDemo.get("women"));
        System.out.println(CacheDemo.get("man")); // 如果没有值,就执行其他方式去获取值
    }
}
