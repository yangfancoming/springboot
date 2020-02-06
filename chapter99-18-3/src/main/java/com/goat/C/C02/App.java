package com.goat.C.C02;

import com.goat.C.common.ConstructorTest;
import org.junit.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: TypeVariable
 *
 * 类型变量中有三个方法：
 * getBounds：返回表示此类型变量上边界的 Type 对象的数组；
 * getGenericDeclaration：返回 GenericDeclaration 对象，该对象表示声明此类型变量的一般声明；
 * getName：返回此类型变量的名称，它出现在源代码中。

 * @ author  山羊来了
 * @ date 2020/2/6---20:10
 */
public class App {

    @Test
    public void test(){

        TypeVariable<Class<ConstructorTest>>[] t = ConstructorTest.class.getTypeParameters();

        for(TypeVariable<Class<ConstructorTest>> m : t) {
            // 获得类型变量在声明的时候的名称，此例中为T
            System.out.println(m.getName());
            /**
             * 获得类型变量的上边界，若无显式的定义（extends）,默认为Object;类型变量的上边界可能不止一个，
             * 因为可以用&符号限定多个（这其中有且只能有一个为类或抽象类，且必须放在extends后的第一个，
             * 即若有多个上边界，则第一个&后必须为接口）
             */
            Type[] bounds = m.getBounds();
            for(Type t1 : bounds) {
                System.out.println(t1);
            }
            // 获得声明这个类型变量的类型及名称  类中：class com.goat.C.common.ConstructorTest
            System.out.println(m.getGenericDeclaration());
        }
    }
}
