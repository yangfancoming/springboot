package com.goat.B.B01.item01;



/**
 * Created by 64274 on 2019/7/14.
 与类的适配器模式相同，对象的适配器模式也是把适配的类的API转换为目标类的API。
 与类适配器模式不同，对象适配器模式采用组合的关系实现适配。
 * @ Description: 类适配器
 * @ author  山羊来了
 * @ date 2019/7/14---11:36
 */
public class App {

    public static void main(String[] args) {
        Source adaptee = new Source();
        Target target = new Adapter(adaptee);
        target.Request();
    }
}
