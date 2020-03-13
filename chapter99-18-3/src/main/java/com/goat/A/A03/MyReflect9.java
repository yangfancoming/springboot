package com.goat.A.A03;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 山羊来了
 * @Description: Class的 isAssignableFrom 方法
 * @date 2019年12月5日15:42:26
 */
public class MyReflect9 {

    /**
     * 有两个Class类型的类象，
     * 一个是调用isAssignableFrom方法的类对象（后称对象a），
     * 以及方法中作为参数的这个类对象（称之为对象b），
     * 即为：  a.isAssignableFrom(b)
     * 这两个对象如果满足以下条件则返回true，否则返回false：
     *
     *     a对象所对应类信息是b对象所对应的类信息的父类或者是父接口，简单理解即a是b的父类或接口
     *     a对象所对应类信息与b对象所对应的类信息相同，简单理解即a和b为同一个类或同一个接口
     *  即：b类是否可以被强制转换为a的实例对象，
     *      Object是所有类的父类
    */
    @Test
    public void test()  {
        Class listClass = List.class ;
        Class arrayListClass = ArrayList.class ;

        System.out.println(listClass.isAssignableFrom(arrayListClass));    //返回true
        System.out.println(listClass.isAssignableFrom(listClass)); // true
        System.out.println(arrayListClass.isAssignableFrom(listClass)); // false
    }


}
