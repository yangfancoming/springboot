package com.goat.Z.Z02.example01;

import java.util.Map;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---12:24
 */
public class Son extends Father{
    //此方法不是重写，而是重载
    public void doSomething(Map map){
        System.out.println("son doSomething");
    }

}