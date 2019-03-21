package com.goat.B.B02;

/**
 * Created by 64274 on 2019/3/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/21---15:59
 */
public class ConcreteDecoratorA extends Decorator {

    private String addedState;
    @Override
    public void operation() {
        // 首先运行原Component的operation()，再执行本类的功能，如addedState，相当于对原Component进行了装饰
        super.operation();
        addedState = "A中的new state ";
        System.out.println(addedState + "具体装饰对象A的操作");
    }
}