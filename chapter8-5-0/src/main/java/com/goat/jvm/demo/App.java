package com.goat.jvm.demo;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---10:55
 */
public class App {

    public static void main(String[] args) {  //main 方法本身放入方法区。

        Sample test1 = new  Sample( " 测试1 " );   //test1是引用，所以放到栈区里， Sample是自定义对象应该放到堆里面
        Sample test2 = new  Sample( " 测试2 " );
        test1.printName();
        test2.printName();
    }
}

