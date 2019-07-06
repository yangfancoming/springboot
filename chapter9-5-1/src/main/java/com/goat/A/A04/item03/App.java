package com.goat.A.A04.item03;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/6---16:21
 */
public class App {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Product build = concreteBuilder
                .bulidA("牛肉煲")
                .bulidC("全家桶")
                .bulidD("冰淇淋")
                .build();
        System.out.println(build.toString());
    }
}
