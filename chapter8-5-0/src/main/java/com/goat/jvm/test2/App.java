package com.goat.jvm.test2;


import org.junit.Test;

public class App {


    /**
     没有 final 的打印情况
     MyParent static BLOCK
     parent hello world

     加上 final 的打印情况
     parent hello world

     因为：常量在编译阶段 会存入到 调用这个常量的方法（ test() ） 所在类（Mytest）的常量池中
     本质上，调用类并没有直接引用到定义常量的类（MyParent），因此不会触发定义常量的类（MyParent）的初始化
    即： MyParent 类 根本就没有被初始化！ 所以不会打印 MyParent static BLOCK

     ldc    表示： 将 int float String 类型的常量值 从常量池中推送至栈顶
     bipush 表示： 将 单字节(-128到127)的常量值推送至栈顶
     当int取值-1~5采用 iconst 指令，
     取值-128~127采用 bipush 指令，
     取值-32768~32767采用 sipush 指令，
     取值-2147483648~2147483647采用 ldc 指令。
     */
    @Test
    public void test1(){
        System.out.println(MyParent.str); // ldc   #4    // String parent hello world
    }

    @Test
    public void test2(){
        System.out.println(MyParent.sht); // bipush        7
    }
}
