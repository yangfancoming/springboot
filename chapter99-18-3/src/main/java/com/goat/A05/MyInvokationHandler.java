package com.goat.A05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 64274 on 2019/5/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/16---10:00
 */
public class MyInvokationHandler implements InvocationHandler{
    /**
     * 执行动态代理的所有方法时,都会白替换成执行如下的invoke方法
     * @param proxy  代表 被代理对象
     * @param method 代表 正在执行的方法
     * @param args   代表 调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        System.out.println("----正在执行的方法：" + method);
        if (args != null){
            System.out.println("下面是执行该方法时传入的实参为：");
            for (Object val : args){
                System.out.println(val);
            }
        }
        else{
            System.out.println("调用该方法没有实参！");
        }
        return null;
    }
}
