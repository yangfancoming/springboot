package com.goat.A03;



import com.goat.model.Dog;
import org.junit.Test;

import java.lang.reflect.*;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
     * @Description: Class 功能 ------ 获取成员变量
     * @author: 杨帆
     * @Date:   2019/11/3
 * 1.获取成员变量
 *      getFields  getField  getDeclaredFields
 * 2.获取构造方法
 * 3.获取成员方法
 * 4.获取类名
*/
public class MyReflect2 extends BaseClass {

    Class<Dog> dogClass = Dog.class;
    /**
     * 1.获取成员变量
     * getFields 该方法只能获取类中public修饰的属性  private、protect等属性是获取不到的！
    */
    @Test
    public void test1()  {
        Field[] publicFields = dogClass.getFields();
        Arrays.stream(publicFields).forEach(x->System.out.println(x));
    }
    /**
     * 1.获取成员变量
     * getField 该方法只能获取类中public修饰的属性  private、protect等属性是获取不到的！
     * 通过指定属性名获取对应 Field 对象
    */
    @Test
    public void test2() throws NoSuchFieldException {
        Field nickName = dogClass.getField("nickName");
        System.out.println(nickName);
    }

    /**
     * Field 对象的get / set 方法
    */
    @Test
    public void test3() throws Exception {
        Field nickName = dogClass.getField("nickName");
        System.out.println(nickName);
        Dog dog = new Dog();
        Object result1 = nickName.get(dog);
        System.out.println("通过 Field 对象获取Dog实例中的 nickName属性：" + result1);
        nickName.set(dog,"123");
        Object result2 = nickName.get(dog);
        System.out.println("通过 Field 对象设置Dog实例中的 nickName属性：" + result2);
        System.out.println(dog);
    }
    /**
     * 1.获取成员变量
     *  getDeclaredFields  该方法 可以获取类中的所有属性   不考虑是修饰符！！
     */
    @Test
    public void test4() {
        Field[] allfields = dogClass.getDeclaredFields();
        for (int i = 0; i < allfields.length; i++) {
            int modifiers = allfields[i].getModifiers();
            // 获取 属性修饰符 + 属性名称
            System.out.println(Modifier.toString(modifiers) + " ----"+ allfields[i].getName());
        }
    }

    /**
     * 1.获取成员变量
     *  getDeclaredFields  该方法 可以获取类中的所有属性   不考虑是修饰符！！
     */
    @Test
    public void test5() throws Exception {
        Field field = dogClass.getDeclaredField("name");
        // 忽略访问权限修饰符的安全检查
        // 设置权限  使其可以访问 类中的私有方法  否则 报权限错误 Class com.goat.A03.MyReflect2 can not access a member of class com.goat.model.Dog with modifiers "private"
        field.setAccessible(true);
        Dog dog = new Dog();
        Object o = field.get(dog);
        System.out.println(o); // null
        field.set(dog,"ting");
        System.out.println(dog);
    }




    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {
        Class<Dog> dogClass = Dog.class;
        Dog dog = dogClass.newInstance(); // 通过class对象 调用默认无参构造函数 来 实例化类对象  （如果没有提供无参构造方法 则会报错）
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.married);
        System.out.println(dog.toString());
    }

    @Test
    public void newInstance2() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class dogClass = Dog.class;
        Dog dog = (Dog)dogClass.newInstance();// 通过class对象 调用默认无参构造函数 来 实例化类对象  （如果没有提供无参构造方法 则会报错）
        Field name = dogClass.getField("nickName");
        name.set(dog,"wahaha");// 这必须是 dog 而不能是  dogClass
        System.out.println(dog);
    }


    @Test
    public void tt() throws  ClassNotFoundException {
        Class<?> aClass = Class.forName(path);
        Method[] declaredMethods = aClass.getDeclaredMethods(); // 获取 本类中定义的方法  包括 私有和公有 但不包括父类的
        for(Method method:declaredMethods){  // 遍历对象中的所有方法
            if(method.getName().equals("shit")){ // 判断出指定方式
                Parameter[] parameters = method.getParameters();
                List<String> collect = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.toList());
                System.out.println(collect);
            }
        }
    }
    @Test
    public void test(){
        Set<String> SET_METHODS = Arrays.stream(PreparedStatement.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getParameterCount() > 1)
                .map(Method::getName)
                .collect(Collectors.toSet());
        System.out.println(SET_METHODS);
    }

}
