package com.goat.B.B03.item08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: 实现 调用管理接口InvocationHandler  创建动态代理类
 * @ author  山羊来了
 * @ date 2019/4/9---19:09
 */
public class BookFacadeProxy implements InvocationHandler {

    //业务实现类对象、用来调用具体的业务方法
    private Object target;

    /**
     * 绑定业务对象并返回一个动态创建的代理类
     */
    public Object bind(Object target) {
        //接收业务实现类对象参数
        this.target = target;
        //通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
        //创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return o;
    }

    /**
     * 包装调用方法：进行预处理、调用后处理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预处理操作——————" + method.getName());
        Object result=method.invoke(target, args);  //调用真正的业务方法
        System.out.println("调用后处理——————" + method.getName());
        return result;
    }

}