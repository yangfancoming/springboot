package com.goat;




import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class TestNG  {



    @Test
    public void test0() throws ClassNotFoundException {

        // 反射拿到 class文件 字节码
        Class<?> aClass = Class.forName("com.goat.bean.User");

        // 拿到类成员属性
//        aClass.getDeclaredFields()

        // 遍历属性


        //拿到注解获取 name值

    }



}
