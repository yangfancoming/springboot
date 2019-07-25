package com.goat.A01;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/16---9:29
 */
public class ClassLoaderTest {


    @Test
    public void test0(){ // 仅仅是加载Tester类
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            classLoader.loadClass("com.goat.A01.Tester");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){ // 会初始化Tester类
        try{
            Class.forName("com.goat.A01.Tester");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}