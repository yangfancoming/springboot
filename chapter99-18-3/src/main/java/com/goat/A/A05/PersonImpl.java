package com.goat.A.A05;

/**
 * Created by 64274 on 2019/10/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/29---21:13
 */
public class PersonImpl implements Person {
    @Override
    public void walk() {
        System.out.println("PersonImpl.............walk");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("PersonImpl.............sayHello");
    }
}
