package com.goat.A.A05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 64274 on 2019/5/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/16---10:01
 */
public class App {

    public static void main(String[] args){

        InvocationHandler handler = new MyInvokationHandler();  //  创建一个InvocationHandler对象
        //  使用指定的InvocationHandler来生成一个动态代理对象
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        //  调用动态代理对象的walk()和sayHello()方法
        person.walk();
        person.sayHello("飞科剃须刀");
    }

}
