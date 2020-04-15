package com.goat.B.B03.item09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 64274 on 2019/11/4.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/4---11:40
 * InvocationHandler接口只有一个待实现的invoke方法。
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * @Description: 这个方法有三个参数
     * @author fan.yang
     * @date 2014年12月19日 上午10:18:20
     * @param proxy proxy表示动态代理类实例
     * @param method method表示调用的方法
     * @param args args表示调用方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("进入JDK动态代理拦截方法---" + method.getName());
        return null;
    }
}