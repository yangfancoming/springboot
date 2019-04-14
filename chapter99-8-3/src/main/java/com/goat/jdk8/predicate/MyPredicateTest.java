package com.goat.jdk8.predicate;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * Created by 64274 on 2019/4/13.
 *
 * @ Description:  Predicate默认实现的三个重要方法and，or和negate 分别对应 java的三个连接符号 &&、|| 和 !
 * @ author  山羊来了
 * @ date 2019/4/13---11:35
 */
public class MyPredicateTest {

    Predicate<Integer> p1 = i->i>5;
    Predicate<String>  p2 = s->s.equals("zhangsan");


    @Test
    public void test(){
        System.out.println(p2.test("lisi"));
        System.out.println(p2.test("zhangsan"));
    }

    @Test
    public void test1(){

    }


    @Test
    public void test2(){

    }
}
