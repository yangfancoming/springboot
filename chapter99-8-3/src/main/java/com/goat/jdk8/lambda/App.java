package com.goat.jdk8.lambda;

import com.goat.jdk8.reference.MyReference;
import org.junit.Test;

import java.util.function.Function;

/**
 lambda 三种编写方式：
 1. expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回
 2. statement  语句块       通过 { } 包裹多条语句 如果是需要返回结果的接口，那么必须显示加上 return 关键字
 3. reference   方法引用  使用场景 ： 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
     static方法的引用	ContainingClass::staticMethodName
     特定对象的方法的引用	containingObject::instanceMethodName
     特定类型的方法的引用	ContainingType::methodName
     构造器的引用	ClassName::new
 */
public class App {

    /** expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回 */
    @Test
    public void test(){
        Function<String,String> function = t->t;
        System.out.println(function.apply("gg"));
    }

    /**
     * 格式： MyFunction function = (x,y)->System.out.println(x + y);
     *      -> lambda操作符 或 箭头操作符
     *      ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
     *      ->右边：lambda体 （其实就是重写的抽象方法的具体实现方法体）
    */
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

    /**
     方法引用： 由于 两个方法的  参数和返回值一样 所以才可以引用
     */

    /* 实例方法引用 */
    @Test
    public void test4(){
        MyReference myReference = new MyReference();
        Function<String,String> function = myReference::test1;
        String wtf = function.apply("wtf");
        System.out.println(wtf);
    }

    /* 静态方法引用 */
    @Test
    public void test8(){
        Function<String,String> function = MyReference::wahaha;
        String wtf = function.apply("wtf");
        System.out.println(wtf);
    }
}
