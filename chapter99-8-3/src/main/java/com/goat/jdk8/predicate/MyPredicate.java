package com.goat.jdk8.predicate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/4/13.
 *
 * @ Description:  Predicate默认实现的三个重要方法and，or和negate 分别对应 java的三个连接符号 &&、|| 和 !
 * @ author  山羊来了
 * @ date 2019/4/13---11:35
 */
public class MyPredicate {

    List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
    Predicate<Integer> p1= i->i>5;
    Predicate<Integer> p2= i->i<20;
    Predicate<Integer> p3= i->i%2==0;
    Predicate<String>  p0 = s->s.equals("zhangsan");


    @Test
    public void test0(){
        System.out.println(p0.test("lisi"));
        System.out.println(p0.test("zhangsan"));
    }

    @Test
    public void tes111t0(){

    }


    /** print:[6, 8, 10, 12, 14]*/
    @Test
    public void test(){
        List test=list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
    }

    /** print:[7, 9, 11, 13, 15]*/
    @Test
    public void test1(){
        List test=list.stream().filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test.toString());
    }

    /** print:[7]
     * isEqual这个方法的返回类型也是Predicate，所以我们也可以把它作为函数式接口进行使用。我们可以当做==操作符来使用。
     * */
    @Test
    public void test2(){
        List test=list.stream().filter(p1.and(p2).and(p3.negate()).and(Predicate.isEqual(7))).collect(Collectors.toList());
        System.out.println(test.toString());
    }
}
