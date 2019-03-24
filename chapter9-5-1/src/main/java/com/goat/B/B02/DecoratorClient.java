package com.goat.B.B02;

/**
 * 装饰模式客户端调用代码，装饰的过程更像是层层包装，用前面的对象装饰后面的对象
 */
public class DecoratorClient {

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