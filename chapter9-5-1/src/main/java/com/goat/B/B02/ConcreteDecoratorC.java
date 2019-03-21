package com.goat.B.B02;

/**
 * Created by 64274 on 2019/3/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/21---15:59
 */
public class ConcreteDecoratorC extends Decorator {
    @Override
    public void operation() {
        super.operation();
        System.out.println("C没有特殊行为 " + "具体装饰对象C的操作");
    }
}