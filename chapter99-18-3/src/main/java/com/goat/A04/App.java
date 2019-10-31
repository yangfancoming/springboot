package com.goat.A04;


import com.goat.model.Constructor0;
import com.goat.model.Constructor1;
import com.goat.model.Constructor2;
import com.goat.model.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 *   反射构造函数 测试
 *   反射创建对象
*/
public class App {

    // 默认构造方法
    Class aClass0 = Constructor0.class;
    Class aClass1 = Constructor1.class;
    Class aClass2 = Constructor2.class;
    Class aClass = Teacher.class;


    /**
     *  通过 test0  test1  test2  test3 四个测试方法 表明
     *  getDeclaredConstructors() 函数返回 该类的所有构造函数 （public 和 private） 系统提供的默认构造函数算做是 已声明的构造函数
     *  getConstructors() 函数只返回 public 构造函数
     *
     *  总结：区别是 getConstructors 只返回public函数，而getDeclaredConstructors 返回所有的构造函数(public，protected，default(package)access和private)
    */
    @Test
    public void test0()  {
        Constructor<?>[] consts = aClass0.getDeclaredConstructors();
        Assert.assertEquals(1,consts.length);
    }

    @Test
    public void test1()  {
        Constructor<?>[] consts = aClass1.getDeclaredConstructors();
        Assert.assertEquals(1,consts.length);
    }

    @Test
    public void test2()  {
        Constructor<?>[] consts = aClass2.getDeclaredConstructors();
        Arrays.stream(consts).forEach(x->System.out.println(x.getParameterTypes().length));
        Assert.assertEquals(4,consts.length);

    }

    @Test
    public void test3()  {
        Constructor<?>[] consts = aClass2.getConstructors();
        Assert.assertEquals(3,consts.length);
    }

    @Test
    public void tesxxx0() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] consts = aClass.getDeclaredConstructors();
        System.out.println(consts.length);
        Teacher o = (Teacher)consts[0].newInstance();
        o.setId(1);
        o.setName("11");
        System.out.println(o);
    }


    /**
     * 获取指定Class对象的默认构造方法（包括无参构造方法）
     */

}
