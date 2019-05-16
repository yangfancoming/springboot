package com.goat.jvm.transmit;

import com.goat.jvm.model.TestClass;
import org.junit.Test;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---16:03
 */
public class App {

    public static void change(int b){
        b = 10;
    }

    /**   1.传递基本类型数据
     *
     结果分析：  不能更改
    在基本类型int创建的过程中，如int a = 5; java首先会在堆栈中（所有基本类型的创建和保存都是在栈中进行的操作）查询有没有 5 这个值，
    如果没有则会在堆栈中开辟一个新的内存空间同时将5置入该空间。然后a这个引用就指向了5所在的内存空间。
    这么看的话，将a传入change()方法之中后，形参b指向了main函数中的实参a的地址（此处也是值传递， 因为java 复制了一份实参a 的地址然后将其赋给b）
    对b进行b=10的操作时，java则按照以上的规则进行操作，由于a,b并不是同一个引用，
    所以当b的引用地址改变成10以后，a所指向的依旧是5所在的地址，这样就可以得到以上的输出结果了
    */
    public static void main(String[] args) {
        int i = 5;
        System.out.println(i);
        change(i);
        System.out.println(i);
    }

    @Test
    public void test1(){
        int a = 5;
        int b = a;
        System.out.println(b);// 5
        b = 10;
        System.out.println(a); // 5
        System.out.println(b); // 10
    }


    /**   2.数组数据传递
     *
     结果分析：  可以更改
     数组实际上结构是保存了一系列的引用，arg[0]是一个指向数组中第一个int储存空间的引用。而arg则是指向了该数组的引用。
     当arg被传入change()方法时，复制了一个arg的引用，但是该arg也是只想实参arg的地址的，所以对arg[0]进行操作时实际上也是对元数组进行了赋值操作，
     当回到main函数时，调用的依旧是change()中操作的地址，所以第二次输出会变成 10 。
     */

    @Test
    public void test2(){
        int[] arg = {1,2,3,4,5,6};
        System.out.println(arg[0]);
        change(arg);
        System.out.println(arg[0]);
    }


    /**  3.对象传递
     *
     结果分析：  可以更改
     cla中的a变量被改变，结果输出为10。
     类是保存在由jvm分配内存保存在堆中的，当类的引用被传递到方法中后，该方法中对该类内的操作都是通过堆内存来操作的，所以会生效
     */
    public static void change(TestClass c){
        c.a = 10;
    }

    @Test
    public void test3(){
        TestClass cla = new TestClass();
        cla.a = 5;
        System.out.println(cla.a);
        change(cla);
        System.out.println(cla.a);
    }


    /**  4. 字符串 传递  特例
     结果分析：  不能更改
     其原理 同  1.传递基本类型数据  这就是 String 的 特殊之处
     */
    public static void changeStr(String c){
        c = "222";
    }

    @Test
    public void test4(){
        String a = "111";
        changeStr(a);
        System.out.println(a);
    }


    public static void change(int[] arg){
        arg[0] = 10;
    }



}