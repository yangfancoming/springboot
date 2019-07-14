package com.goat.B.B01.item00;

/**
 * Created by 64274 on 2019/7/14.
 * Target期待调用Request方法，而Adaptee没有(这就是所谓的不兼容了)，
 * 为使Target能够使用Adaptee类的SpecificRequest方法，
 * 故提供一个中间环节Adapter类(继承Adaptee&实现Target接口)，
 * 把Adaptee的API与Target的API衔接起来(适配)
 * @ Description: 类适配器
 * @ author  山羊来了
 * @ date 2019/7/14---11:36
 */
public class App {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}
