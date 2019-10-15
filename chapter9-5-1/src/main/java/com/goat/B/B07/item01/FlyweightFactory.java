package com.goat.B.B07.item01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2019/4/25.
 *
 * @Description: TODO
 * @author  山羊来了
 * @date 2019/4/25---18:45
 */
public class FlyweightFactory{

    static Map<String, Shape> shapes = new HashMap<>();

    public static Shape getShape(String key){
        if (shapes.containsKey(key)){
            return shapes.get(key);
        }
        //不存在,则新建,并且保持到共享池中
        Shape shape = new Circle(key);
        shapes.put(key, shape);
        return shape;
    }

    public static int getSum(){
        return shapes.size();
    }
}