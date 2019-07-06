package com.goat.A09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/6/25.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/6/25---17:14
 *
 * ArrayList可以存放任意类型，例子中添加了一个String类型，添加了一个Integer类型，再使用时都以String的方式使用，因此程序崩溃了。
 * 为了解决类似这样的问题（在编译阶段就可以解决），sos 泛型 应运而生。
 *  泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法
 * 泛型中的 <T> 只能是引用类型！
 */
public class MyTest {

    /* 在集合中 存储了不同类型的数据  导致在使用集合时 容易报错 */
    @Test
    public void test(){
        List strList = new ArrayList();  // ① 表示 创建的 strList 集合 可以保存任何类型
        strList.add("天晴");
        strList.add("下雨");
        strList.add(50);    // ② 引起运行时错误 java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        strList.forEach(System.out::println);
        strList.forEach(str -> System.out.println(str)); // 但是 使用这两种方式遍历 就可以在遍历时不指定元素类型。。。。 可以正常遍历
        System.out.println("...............");
        strList.forEach(str -> System.out.println(((String)str).length())); // ③ 一旦在遍历时 指定了元素类型  那么如果集合中有元素类型不同则会报错
    }

    /* 解决方法： 在创建集合时 就指定 集合可以存储的元素类型 这样在编译阶段就保证集合的元素类型 安全 */
    @Test
    public void test2(){
        List<String> strList = new ArrayList<>();  // ① 表示 创建的 strList 集合 只可以保存String类型
        strList.add("天晴");
        strList.add("下雨");
//        strList.add(5);    // ② 将引起编译错误
        strList.forEach(str -> System.out.println(str.length())); // ③ 遍历books集合，集合元素就是String类型
    }

    @Test
    public void test3(){
        Map<String , List<String>> schoolsInfo = new HashMap<>();
        List<String> schools = new ArrayList<>();
        schools.add("斜月三星洞");
        schools.add("西天取经路");
        schoolsInfo.put("孙悟空" , schools);
        // 遍历Map时，Map的key是String类型，value是List<String>类型
        schoolsInfo.forEach((key , value) -> System.out.println(key + "-->" + value));
    }

    /**
     通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。
     在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
     也就是说，泛型信息不会进入到运行时阶段。
     对此总结成一句话：泛型类型在逻辑上可以看成是多个不同的类型，实际上都是相同的基本类型。
    */
    @Test
    public void test4(){
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("两个泛型类型相同");
        }
        else {
            System.out.println("两个泛型类型不相同");
        }

        if(classStringArrayList== classIntegerArrayList){
            System.out.println("两个泛型类型相同");
        }
        else {
            System.out.println("两个泛型类型不相同");
        }
    }
}
