package com.goat.B.B05.example01.shape;

import com.goat.B.B05.example01.Color;
import com.goat.B.B05.example01.Shape;

/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---15:28
 */
public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    public void draw() {
        color.bepaint("长方形");
    }

}