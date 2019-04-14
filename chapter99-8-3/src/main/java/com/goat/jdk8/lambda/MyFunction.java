package com.goat.jdk8.lambda;

/**
 * Created by 64274 on 2019/4/14.
 *
 * @ Description: 函数式接口
 * @ author  山羊来了
 * @ date 2019/4/14---8:49
 函数式接口特征：
 1. 接口中标注了  @FunctionalInterface 注解
 2. 接口中只有一个抽象方法 会被编译器自动认识成函数式接口
 3. 接口中有一个抽象，同时包含了 Object 类的其他抽象方法也会被识别成抽象接口
 */
@FunctionalInterface
public interface MyFunction {

    void sayHello(String name,String content); //  2.接口中只有一个抽象方法 会被编译器自动认识成函数式接口

    String toString(); // 3.接口中有一个抽象，同时包含了 Object 类的其他抽象方法也会被识别成抽象接口

    default void sayHi(){ // 如果有多个  则可以定义成 默认实现方法
        System.out.println("Hi!!!!");
    }
}
