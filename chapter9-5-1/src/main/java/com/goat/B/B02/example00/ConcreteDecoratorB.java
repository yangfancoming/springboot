package com.goat.B.B02.example00;

/**
 * Created by 64274 on 2019/3/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/21---15:59
 */
public class ConcreteDecoratorB extends Decorator {


    public void addedBehavior() {
        System.out.print("B中的新增行为 ");
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }
}