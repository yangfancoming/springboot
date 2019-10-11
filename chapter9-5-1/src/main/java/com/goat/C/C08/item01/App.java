package com.goat.C.C08.item01;

import org.junit.Test;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description:         每天的不同时间工作会有不同的工作状态，我们用面向对象来实现一下：
 * @ author  山羊来了
 * @ date 2019/10/11---15:45
 *
 *
 * 上面的代码虽然可以实现功能，但是方法中的代码过长，这通常不是一个好的代码，writeProgram()中不应该有太多的判断。
 * 要知道这个方法很长，而且有很多判断分支，这就意味着它的责任过大了。无论任何状态，都需要通过它来改变，这实际上是很糟糕的。
 *
 * 面向对象设计其实就是希望做到代码责任的分解。
 * 这个类违背了“单一职责原则”，维护出错的风险过大，所以我们可以将这些分支变为一个个的类，
 * 增加时又不会影响其它类。然后状态的变化在各自的类中完成，这种解决方案就是状态设计模式。

 */
public class App {

    @Test
    public void test(){
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(14);
        work.writeProgram();
        work.setHour(17);
        work.writeProgram();

        // 假设完成工作
        work.setFinish(true);
        work.writeProgram();
        work.setHour(19);
        work.writeProgram();
        work.setHour(22);
        work.writeProgram();
    }
}
