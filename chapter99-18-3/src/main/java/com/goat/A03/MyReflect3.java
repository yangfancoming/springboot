package com.goat.A03;



import com.goat.model.Car;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 64274 on 2018/7/30.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/30---20:47
 */
public class MyReflect3 {

    public static final String path = "com.goat.model.Car";

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过类加载器 获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass(path);
        testCar(clazz);
    }

    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(path);
        // 获取类的默认构造函数对象 并通过它来实例化对象
        testCar(clazz);
    }

    public void testCar(Class clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 获取类的默认构造函数对象 并通过它来实例化对象
        Car car = (Car) gaga(clazz);
        // 通过反射方法设置对象属性
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"宝马");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"白色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,123);
        car.introduce();
    }

    public <T> T gaga(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        return (T)constructor.newInstance();
    }
}
