package com.goat.A.A04.item05;

/**
 * Created by 64274 on 2019/8/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/5---9:35
 */
public class App {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        // 指挥者使用 ConcreteBuilder1 的方法来建造产品
        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        // 指挥者使用 ConcreteBuilder2 的方法来建造产品
        director.construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
