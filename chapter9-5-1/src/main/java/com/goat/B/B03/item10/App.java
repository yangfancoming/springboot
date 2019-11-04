package com.goat.B.B03.item10;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by 64274 on 2019/11/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/4---14:45
 */
public class App {

    @Test
    public void test(){
        Subject realSubject = new RealSubject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Subject.class},myInvocationHandler);
        System.out.println(proxyClass.sellBooks());
        System.out.println(proxyClass.speak());
    }
}
