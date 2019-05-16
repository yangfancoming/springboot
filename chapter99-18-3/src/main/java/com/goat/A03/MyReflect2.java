package com.goat.A03;



import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created by 64274 on 2018/7/20.
 * @author 山羊来了
 * @Description: 获取class的四种方式
 *     第一种：通过Object类的getClass方法     Class cla = foo.getClass();
 *     第二种：通过对象实例方法获取对象      Class cla = foo.class; 或 Class forClass = com.hqh.reflect.UseInfo.class ;
 *     第三种：通过 通过类名的字符串获取对象 Class.forName方式   Class cla = Class.forName("xx.xx.Foo");
 *     第四种：通过子类的实例获得父类对象   Class subUserClass = userClass.getSuperclass() ;
 * @date 2018/7/20---18:56
 *
 */
public class MyReflect2 {

    public static final String path = "com.goat.A03.Dog";

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

    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {
        Class<Dog> dogClass = Dog.class;
        Dog dog = dogClass.newInstance(); // 通过class对象 调用默认无参构造函数 来 实例化类对象  （如果没有提供无参构造方法 则会报错）
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.married);
    }

    @Test
    public void getConstructor() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors(); // 获取 指定类的所有构造函数
        System.out.println(constructors);
        Constructor<Dog> constructor1 = dogClass.getConstructor(String.class, Integer.class); // 获取指定构造函数

        Dog dog1 = constructor1.newInstance("山羊来了111", 111); // 使用反射获取指定构造函数 来创建类对象
        System.out.println(dog1.toString());

        Constructor<Dog> constructor2 = dogClass.getConstructor(); // 获取无参造函数
        Dog dog2 = constructor2.newInstance(); // 使用无参构造函数 来创建类对象
        System.out.println(dog2.toString());
    }

    @Test
    public void test4()  {
        Class<Dog> dogClass = Dog.class;
        Field[] publicfields1 = dogClass.getFields();  // 该方法只能获取 类中 public属性  private属性是获取不到的！
        System.out.println(publicfields1);
        getDeclaredFields(dogClass);
    }

    public static void getDeclaredFields(Class<?> aClass) {
        Field[] allfields1 = aClass.getDeclaredFields();  // 该方法 可以获取类中的所有属性   无论公有还是私有
        for (int i = 0; i < allfields1.length; i++) {
            int modifiers = allfields1[i].getModifiers();
            System.out.println(Modifier.toString(modifiers) + allfields1[i].getName());// 获取 属性修饰符 + 属性名称
        }
    }

    @Test
    public void getMethods() throws IllegalAccessException,  InvocationTargetException {
        Class<Dog> dogClass = Dog.class;
        Package aPackage = dogClass.getPackage();// 获取类所在包名
        System.out.println(aPackage.getName());
        Method[] methods = dogClass.getMethods(); // 获取类中的所有公有方法 和继承的公有方法  私有和protect 是获取不到的
        for(Method method:methods){
            System.out.println(method.getName());
            if(method.getName().equals("toString")){
                Object invoke = method.invoke(new Dog("wowo",53)); // 通过反射 调用类中公有的方法
                System.out.println(invoke);
            }
        }
    }

    @Test
    public void getDeclaredMethods() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Class<?> aClass = Class.forName(path);
        Method[] declaredMethods = aClass.getDeclaredMethods(); // 获取 本类中定义的方法  包括 私有和公有 但不包括父类的
        for(Method method:declaredMethods){  // 遍历对象中的所有方法
            System.out.println(method.getName());
            if(method.getName().equals("fuck")){ // 判断出指定方式
                method.setAccessible(true); // 设置权限  使其可以访问 类中的私有方法  否则 报权限错误
                method.invoke(aClass.newInstance()); // 通过反射 调用类中的方法
            }
        }
    }

}
