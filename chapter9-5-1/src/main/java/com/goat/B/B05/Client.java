package com.goat.B.B05;

import com.goat.B.B05.color.Color;
import com.goat.B.B05.color.Gray;
import com.goat.B.B05.color.White;
import com.goat.B.B05.shape.Rectangle;
import com.goat.B.B05.shape.Shape;
import com.goat.B.B05.shape.Square;

/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---15:29
 */
public class Client {

    public static void main(String[] args) {
        //白色
        Color gray = new Gray();
        Color white = new White();

        Shape square = new Square(white); //白色的正方形
        square.draw();

        Shape rectange = new Rectangle(gray); //白色的长方形
        rectange.draw();
    }
}