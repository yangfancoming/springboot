package com.goat.jvm.test;


import org.junit.Test;

/**
 *  静态代码块
 *  对于静态字段，只有直接定义了该字段的类才会被初始化
 *  当一个类在初始化时，要求其所有父类 必须都要加载完毕！

*/

public class App {


    /**  注释掉 子类中的 public static String str = "child hello world";
     MyParent static BLOCK
     hello world
     因为 注释掉 后 实际访问的是 父类的 str 因此不会实例化 子类
     */
    @Test
    public void test(){
        System.out.println(MyChild.str);
    }

    /**  取消注释  子类中的 public static String str = "child hello world";
     MyParent static BLOCK
     MyChild static BLOCK
     hello world
     因为 取消注释 后 实际访问的是 字类的 str 因此会实例化 子类
     */
    @Test
    public void test2(){
        System.out.println(MyChild.str);
    }

}
