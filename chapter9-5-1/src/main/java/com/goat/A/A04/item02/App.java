package com.goat.A.A04.item02;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/6---16:17
 */
public class App {

    public static void main(String[] args) {
        Director director = new Director();
        Product create = director.create(new ConcreteBuilder());
        System.out.println(create.toString());
    }

}
