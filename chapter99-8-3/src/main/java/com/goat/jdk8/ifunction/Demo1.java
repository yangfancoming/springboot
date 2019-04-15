package com.goat.jdk8.ifunction;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by 64274 on 2019/4/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/14---20:25
 */
public class Demo1 {

    List<String> list3 = Arrays.asList("a","c","f","b","d","e","g");
    List<String> list1 = Arrays.asList("1","3","5","7","2","4","6");
    @Test
    public void test1(){
        list3.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * toUpperCase 方法 第二个参数为返回值 String  sos 第一个参数输入参数 （调用toUpperCase方法的String对象）
     * 因此 函数式接口 Function<String,String> 可以接收 String::toUpperCase
     * */
    @Test
    public void test2(){
        Function<String,String> function = String::toUpperCase; // 类::类中的实例方法
        list3.stream().map(function).forEach(System.out::println);
    }

    @Test
    public void test3(){
        Collections.sort(list1, Comparator.reverseOrder()); //
        list1.forEach(System.out::println);

        System.out.println("---------------------------");
        Collections.sort(list1, Comparator.naturalOrder());
        list1.forEach(System.out::println);
    }
}
