package com.goat.Z.Z02.example02;

import java.util.HashMap;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---12:24
 */
public class Son extends Father {
    //此方法不是重写，而是重载,但是和前一个不同，它没有扩大参数类型，而是缩小了参数的类型
    public void doSomething(HashMap map){
        System.out.println("son doSomething");
    }

}