package com.goat;


import com.goat.annotation.Init;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class PersonApp {

    @Test
    public void test0() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.goat.entity.Person");
        Field[] allfields = aClass.getDeclaredFields();

        for (Field field:allfields){
            // Person 类中的   @Init("13845632145") 注解 是没有写属性名的
            Init init = field.getDeclaredAnnotation(Init.class);
            if(init != null){
                System.out.println(init.value());
            }
        }
    }


}
