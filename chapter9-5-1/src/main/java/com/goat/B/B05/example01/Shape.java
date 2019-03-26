package com.goat.B.B05.example01;


/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---15:27
 */
public abstract class Shape {

   public Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}