package com.goat.B.B05.shape;

import com.goat.B.B05.color.Color;

/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---15:28
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    public void draw() {
        color.bepaint("正方形");
    }

}