package com.goat.B.B03.example05;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/9---18:11
 */
public class DaoProxy implements MethodInterceptor {

    /**
     Object 表示要进行增强的对象
     Method 表示拦截的方法
     Object[] 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     MethodProxy 表示对方法的代理，invokeSuper 方法表示对被代理对象方法的调用
    */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib动态代理 前置增强  记录日志");
        proxy.invokeSuper(object, args); // UserDao.update() select
        System.out.println("cglib动态代理 后置增强  记录日志");
        return object;
    }

}