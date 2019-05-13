package com.goat.B.B07.item01;

/**
 * Created by 64274 on 2019/4/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/25---18:46
 */
public class App {

    public static void main(String[] args) {
        Shape shape1 = FlyweightFactory.getShape("red");
        shape1.draw();

        Shape shape2 = FlyweightFactory.getShape("gray");
        shape2.draw();

        Shape shape3 = FlyweightFactory.getShape("green");
        shape3.draw();

        Shape shape4 = FlyweightFactory.getShape("red");
        shape4.draw();

        Shape shape5 = FlyweightFactory.getShape("gray");
        shape5.draw();

        System.out.println("一共绘制了"+FlyweightFactory.getSum()+"中颜色的圆形");
    }
}
