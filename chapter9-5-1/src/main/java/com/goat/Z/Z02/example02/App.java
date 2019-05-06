package com.goat.Z.Z02.example02;

import java.util.HashMap;

/**
 * Created by 64274 on 2019/5/6.
 可以看到出现了问题:子类没有覆盖父类的同名方法(只是重载了)，但是却运行了子类的方法。
 这样做就出现了逻辑混乱(要想让子类的方法运行，就必须覆盖重载父类的同名方，然而实际上子类并没有覆盖父类的同名方法，但是还是用了子类的方法)。
 总结:父类的一个方法在子类中可以被重写，也可以被重载，但是重载时的参数类型必须大于父类同名方法中的参数类型
 sos 我的总结： 在子类重载父类方法时  new 父类  new 子类 分别调用方法时 是根据调用参数类型 来确定 到底调用 父类的方法 还是子类的方法！！！
     如果是子类重写 父类的方法 那么 不用想 肯定是调用子类的方法！
 * @ Description: 父类为：Map   子类为：HashMap
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
        son.doSomething(new HashMap()); // 客户端依然输出：son doSomething
    }
}
