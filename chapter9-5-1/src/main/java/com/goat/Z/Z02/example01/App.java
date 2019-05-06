package com.goat.Z.Z02.example01;

import java.util.HashMap;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: ③覆盖或者实现父类的方法时输入参数可以被放大  父类为：HashMap  子类为：Map
 * @ author  山羊来了
 * @ date 2019/5/6---12:25
 */
public class App {

    public static void main(String[] args){
        //此处为父类出现的地方，一会根据里氏替换原则会换成子类
        Father father = new Father();
        father.doSomething(new HashMap()); // 客户端输出：father doSomething

        //  根据里氏替换原则做对客户端代码做如下修改:
        Son son = new Son();
        son.doSomething(new HashMap()); // 客户端依然输出：father doSomething。
    }
}
