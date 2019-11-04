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
        // Proxy.newProxyInstance方法创建一个动态代理类实例，这个方法需要传入三个参数
        // 第一个参数是类加载器，用于加载这个代理类。第二个参数是Class数组，里面存放的是待实现的接口信息。第三个参数是InvocationHandler实例。
        InvocationHandler invocationHandler = new MyInvocationHandler();
        MyIntf proxyObj = (MyIntf) Proxy.newProxyInstance(MyIntf.class.getClassLoader(),new Class[]{MyIntf.class},invocationHandler);
        proxyObj.helloWorld();
    }
}
