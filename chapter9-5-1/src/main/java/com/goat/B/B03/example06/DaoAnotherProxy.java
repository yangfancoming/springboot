package com.goat.B.B03.example06;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 1、正确：一般通过代理实例上反射调用代理方法来调用到目标方法。
 Object returnVal = proxyMethod.invokeSuper(proxyObj,args);
 2、错误：在代理实例上反射调用目标方法，会递归调用到代理方法，陷入死循环，最终报错
 *** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
 Object returnVal = targetMethod.invoke(proxyObj,args);
 3、错误：在代理实例上反射调用目标方法。最终报错，结果同2
 Object returnVal = proxyMethod.invoke(proxyObj,args);
 4、正确：构造增强器/拦截器实例时，传入目标类实例targetObj，则可以在此通过目标类实例反射调用目标方法。
 Object returnVal = targetMethod.invoke(targetObj,args);
 */
public class DaoAnotherProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        // method.invoke(object, args); // sos  对应上面 错误2
        proxy.invokeSuper(object, args); // 正确
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
        return object;
    }


}

