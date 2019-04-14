package com.goat.jdk8.lambda;

/**
 * Created by 64274 on 2019/4/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/14---9:23
 */
public class MyReference {

    // 实例方法引用
    public  String test1(String name){
        System.out.println(name);
        return name + "test1!";
    }

    public static String wahaha(String name){
        System.out.println(name);
        return name + "wahaha!";
    }


}
