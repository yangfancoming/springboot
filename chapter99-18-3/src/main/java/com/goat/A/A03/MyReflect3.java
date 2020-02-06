package com.goat.A.A03;


import com.goat.model.Dog;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
     * @Description: Class 功能 ------ 获取构造方法
     * @author: 杨帆
     * @Date:   2019/11/3
 * 1.获取成员变量
 *      getFields  getField  getDeclaredFields
 * 2.获取构造方法
 * 3.获取成员方法
 * 4.获取类名
*/
public class MyReflect3 extends BaseClass {

    Class<Dog> dogClass = Dog.class;

    @Test
    public void getConstructors() {
        Constructor<?>[] constructors = dogClass.getConstructors(); // 获取 指定类的所有构造函数
        System.out.println(constructors);
    }

    @Test
    public void getConstructor1() throws Exception {
        Constructor<Dog> constructor1 = dogClass.getConstructor(String.class, Integer.class); // 获取指定构造函数
        Dog dog1 = constructor1.newInstance("山羊来了111", 111); // 使用反射获取指定构造函数 来创建类对象
        System.out.println(dog1.toString());
    }

    @Test
    public void getConstructor2() throws Exception {
        Constructor<Dog> constructor2 = dogClass.getConstructor(); // 获取无参造函数
        Dog dog2 = constructor2.newInstance(); // 使用无参构造函数 来创建类对象
        System.out.println(dog2.toString());
    }
}
