package com.goat.java;


import com.goat.scala.Hello;

/**
 * Created by 64274 on 2018/11/29.
 *
 * @author 山羊来了
 * @Description:  Java 调用 Scala
 * @date 2018/11/29---17:22
 */
public class HelloWorld {

    public static void main(String[] args){
        Hello h = new Hello();
        h.sayHello("scala");
    }
}
