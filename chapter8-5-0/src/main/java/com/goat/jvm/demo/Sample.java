package com.goat.jvm.demo;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---10:56
 */
public class Sample {  //运行时, jvm 把appmain的信息都放入方法区

    /** 范例名称 */
    private String name;      //new Sample实例后， name 引用放入栈区里, name 对应的 String 对象放入堆里

    /** 构造方法 */
    public  Sample(String name) {
        this .name = name;
    }

    /** 输出 */
    public   void  printName(){   //在没有对象的时候，print方法跟随sample类被放入方法区里。
        System.out.println(name);
    }
}

