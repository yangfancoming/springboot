package com.goat.A03;


import com.goat.model.Dog;
import org.junit.Test;

/**
 * Created by 64274 on 2018/7/20.
 * @author 山羊来了
 * @Description: 获取class的四种方式  反射四种方式 反射的四种方式
 *     第一种方式：通过类名的字符串获取对象  Class.forName方式   Class cla = Class.forName("xx.xx.Foo");  多用于配置文件中。。。
 *     第二种方式：通过对象实例方法获取对象       Class cla = foo.class; 或 Class forClass = com.hqh.reflect.UseInfo.class ;多用于参数的传递。。。
 *     第三种方式：通过Object类的getClass方法     Class cla = foo.getClass();   多用于对象的获取字节码的方式
 *     第四种方式：通过子类的实例获得父类对象     Class subUserClass = userClass.getSuperclass() ;
 * @date 2018/7/20---18:56
 */
public class MyReflect1 extends BaseClass {

    /* 同一个字节码文件(*.class)再一次程序运行过程中，只会被加载一次，不论通过哪种方式获取的class对象都是同一个*/
    @Test
    public void test11() throws ClassNotFoundException {
        // 第一种方式：通过 通过类名的字符串获取对象  Class.forName方式   Class cla = Class.forName("xx.xx.Foo");
        Class cls1 = Class.forName(path);
        //  第二种方式：通过对象实例方法获取对象
        Class cls2 = Dog.class;
        // 第三种方式：通过Object类的getClass方法     Class cla = foo.getClass();
        Class cls3 = new Dog().getClass();
        Class cls4 = new Dog("hahagou",12).getClass();
        System.out.println(cls1 == cls2 && cls2 == cls3 && cls3 == cls4);
    }

    @Test
    public void test0() throws ClassNotFoundException {
        Class<?> aClass = Class.forName(path);
        System.out.println(aClass);
    }

    @Test
    public void test1() {
        Dog dog = new Dog("hahagou",12);
        Class<? extends Dog> aClass = dog.getClass();
        System.out.println(aClass);
    }
}
