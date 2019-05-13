package com.goat.B.B02.example00;

/**
 * Created by 64274 on 2019/4/26.
 * 装饰模式客户端调用代码，装饰的过程更像是层层包装，用前面的对象装饰后面的对象
 * @ Description: 双抽象类  模式
 * @ author  山羊来了
 * @ date 2019/4/26---15:07
 */
public class App {

    public static void main(String[] args) {
//        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
        ConcreteDecoratorC concreteDecoratorC = new ConcreteDecoratorC();

//        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorC.setComponent(concreteDecoratorB);
//        concreteDecoratorC.setComponent(concreteDecoratorA);
        concreteDecoratorC.operation();
//        concreteDecoratorB.operation();
//        concreteDecoratorA.operation();
    }
}
