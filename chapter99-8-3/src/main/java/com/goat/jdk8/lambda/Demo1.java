package com.goat.jdk8.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 lambda 三种编写方式：
 1. expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回
 2. statement  语句块       通过 { } 包裹多条语句 如果是需要返回结果的接口，那么必须显示加上 return 关键字
 3. refrence   方法引用
 */
public class Demo1 {

    /** expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回 */
    @Test
    public void test(){
        Function<String,String> function = t->t;
        System.out.println(function.apply("gg"));
    }


    @Test
    public void test1(){
       MyFunction function = (x,y)->System.out.println(x + y);
        function.sayHello("石涵之","gg");
    }

    /** statement  语句块   通过 { } 包裹多条语句 */
    @Test
    public void test2(){
        MyFunction function = (x,y)->{
            System.out.println(x);
            System.out.println("------------");
            System.out.println(y);
        };
        function.sayHello("石涵之","gg");
    }

    /** statement  语句块   通过 { } 包裹多条语句  如果是需要返回结果的接口，那么必须显示加上 return 关键字 */
    @Test
    public void test3(){
        MyFunction2 function = (x,y)->{
            System.out.println(x);
            System.out.println("------------");
            System.out.println(y);
            return "wtf";
        };
        String s = function.sayHello("石涵之", "gg");
        System.out.println(s);
    }
}
