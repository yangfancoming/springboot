package com.goat.B.B05.example00;



/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---15:29
 */
public class Client {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();

        //调用第一个实现类
        abstraction.setImplementor(new ConcreateImplementorA());
        abstraction.operation();

        //调用第二个实现类
        abstraction.setImplementor(new ConcreateImplementorB());
        abstraction.operation();

    }
}