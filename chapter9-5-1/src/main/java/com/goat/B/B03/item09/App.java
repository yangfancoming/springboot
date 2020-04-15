package com.goat.B.B03.item09;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 64274 on 2019/11/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/4---11:43
 */
public class App {

    @Test
    public void test(){

        InvocationHandler invocationHandler = new MyInvocationHandler();
        /**
         * Proxy.newProxyInstance方法创建一个动态代理类实例，这个方法需要传入三个参数
         * @param P1 类加载器，用于加载这个代理类。
         * @param P2 Class数组，里面存放的是待实现的接口信息。
         * @param P3 InvocationHandler实例。
         */
        MyIntf proxyObj = (MyIntf) Proxy.newProxyInstance(MyIntf.class.getClassLoader(),new Class[]{MyIntf.class},invocationHandler);
        proxyObj.helloWorld();
    }
}
