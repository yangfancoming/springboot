package com.goat.A.A03;


import com.goat.model.Dog;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
     * @Description: Class 功能 ------ 获取成员方法  Methods
     * @author: 杨帆
     * @Date:   2019/11/3
 * 1.获取成员变量
 *      getFields  getField  getDeclaredFields
 * 2.获取构造方法
 * 3.获取成员方法
 * 4.获取类名
*/
public class MyReflect4 extends BaseClass {

    Class<Dog> dogClass = Dog.class;

    Dog dog = new Dog();

    // 获取类所在包名
    @Test
    public void test1(){
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
    }

    // 获取类中的所有公有方法 和继承的公有方法  私有和protect 是获取不到的
    @Test
    public void getMethods(){
        Method[] methods = dogClass.getMethods();
        Arrays.stream(methods).forEach(x->System.out.println(x.getName()));
    }

    // 调用成员方法
    @Test
    public void getMethod() throws Exception{
        Method eat1 = dogClass.getMethod("eat1");
        eat1.invoke(dog); // 通过反射 调用类中的无参方法

        Method eat2 = dogClass.getMethod("eat2", String.class);//
        eat2.invoke(dog,"goat"); // 通过反射 调用类中的有参方法

        Method fuck = dogClass.getMethod("fuck");//
        fuck.invoke(dog); // 通过反射 调用类中的private方法  报错：java.lang.NoSuchMethodException: com.goat.model.Dog.fuck()
    }

    @Test
    public void getDeclaredMethods() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Class<?> aClass = Class.forName(path);
        Method[] declaredMethods = aClass.getDeclaredMethods(); // 获取 本类中定义的方法  包括 私有和公有 但不包括父类的
        for(Method method:declaredMethods){  // 遍历对象中的所有方法
            System.out.println(method.getName());
            Class<?> declaringClass = method.getDeclaringClass(); // 通过方法获取 该方法所在类/接口 对象
            System.out.println(declaringClass);
            if(method.getName().equals("fuck")){ // 判断出指定方式
                method.setAccessible(true); // 设置权限  使其可以访问 类中的私有方法  否则 报权限错误
                method.invoke(aClass.newInstance()); // 通过反射 调用类中的方法
            }
        }
    }

}
