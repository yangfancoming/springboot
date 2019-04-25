package com.goat.B.B07;

/**
 * Created by 64274 on 2019/4/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/25---18:45
 */
public class Circle extends Shape{

    private String color;

    public Circle(String color){
        this.color = color;
    }

    public void draw() {
        System.out.println("画了一个" + color +"的圆形");
    }

}