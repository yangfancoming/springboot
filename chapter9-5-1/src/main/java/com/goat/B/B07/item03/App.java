package com.goat.B.B07.item03;

import org.junit.Test;

/**
 * Created by 64274 on 2019/10/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/15---17:08
 *
 * Flyweight是抽象享元角色。它是产品的抽象类，同时定义出对象的外部状态和内部状态（外部状态及内部状态相关内容见后方）的接口或实现；
 * ConcreteFlyweight是具体享元角色，是具体的产品类，实现抽象角色定义的业务；
 * UnsharedConcreteFlyweight是不可共享的享元角色，一般不会出现在享元工厂中；
 * FlyweightFactory是享元工厂，它用于构造一个池容器，同时提供从池中获得对象的方法
 *
 * 从这个结果我们可以看出来，第一次创建X、Y、Z时，都是先创建再从池中取出，而第二次创建X时，因为池中已经存在了，所以直接从池中取出，这就是享元模式。
 */
public class App {

    @Test
    public void test(){
        int extrinsic = 22;

        Flyweight flyweightX = FlyweightFactory.getFlyweight("X");
        flyweightX.operate(++ extrinsic);

        Flyweight flyweightY = FlyweightFactory.getFlyweight("Y");
        flyweightY.operate(++ extrinsic);

        Flyweight flyweightZ = FlyweightFactory.getFlyweight("Z");
        flyweightZ.operate(++ extrinsic);

        Flyweight flyweightReX = FlyweightFactory.getFlyweight("X");
        flyweightReX.operate(++ extrinsic);

        Flyweight unsharedFlyweight = new UnsharedConcreteFlyweight("X");
        unsharedFlyweight.operate(++ extrinsic);
    }
}

