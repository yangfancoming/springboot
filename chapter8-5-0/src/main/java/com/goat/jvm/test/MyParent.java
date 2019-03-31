package com.goat.jvm.test;

/**
 * Created by 64274 on 2019/3/31.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/31---17:03
 */
public class MyParent {

    public static String str = "parent hello world";

    static {
        System.out.println("MyParent static BLOCK");
    }
}
