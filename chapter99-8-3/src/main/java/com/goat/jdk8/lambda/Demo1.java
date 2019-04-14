package com.goat.jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 64274 on 2019/4/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/14---20:25
 */
public class Demo1 {

    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
    List<Integer> list2 = new ArrayList<>();
    List<String> list3 = Arrays.asList("a","b","c","d","e","f","g");
    @Test
    public void test1(){  // 传统 for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2(){ // 增强 for循环
        for (Integer temp : list){
            System.out.println(temp);
        }
    }

    @Test
    public void test3(){ // lambda
        list.forEach(x->System.out.println(x));
    }

    @Test
    public void test4(){ // lambda 方法引用
        list.forEach(System.out::println);
    }

    @Test
    public void test5(){ //  给另一个集合 赋值
        list.forEach(x->list2.add(x*2));
        list2.forEach(System.out::println);
    }

    @Test
    public void test6(){ // 将 list  转成 流  通过 map 映射数据 成 大写 再通过 forEach 进行遍历
        list3.stream().map(x->x.toUpperCase()).forEach(System.out::println); // 写法一
        list3.stream().map(String::toUpperCase).forEach(System.out::println); // 写法二  方法引用
    }
}
