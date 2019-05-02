package com.goat.jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda表达式的使用：（分为6种情况介绍）
 *
 *    总结：
 *    ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *    ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 */
public class Demo {

    @Test
    public void test1(){  // 语法格式一：无参，无返回值
        Runnable r2 = () ->System.out.println("我爱北京故宫");
        r2.run();
    }

    @Test
    public void test2(){ // 语法格式二：Lambda 需要一个参数，但是没有返回值。
        Consumer<Integer> con = (s)->System.out.println(s);
        con.accept(1);


    }

    @Test
    public void test4(){ // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = s->System.out.println(s); // (s) --- s
        con1.accept("1");
    }

    @Test
    public void test5(){  //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        MyFunction2 function = (x,y)->{
            System.out.println(x);
            System.out.println(y);
            return "wtf";
        };
        String s = function.sayHello("goat", "lucky");
        System.out.println(s);
    }

    @Test
    public void test6(){  //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Runnable r2 = () ->System.out.println("我爱北京故宫");
        r2.run();
    }
}
