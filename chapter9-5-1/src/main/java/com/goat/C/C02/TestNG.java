package com.goat.C.C02;

import org.testng.annotations.Test;


/**
     * @Description:  模板方法 设计模式
     * @author: 杨帆
     * @Date:   2018/11/4
 *
　（1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构。
　（2）代码复用的基本技术，在数据库设计中尤为重要。
　（3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”。
*/
public class TestNG {

    @Test
    public void test() {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.spit = true;// 通知厨师吐痰
        eggsWithTomato.dodish();
        System.out.println("番茄炒蛋。。。。。。。。。。。。。。。OK！");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
        System.out.println("红烧肉。。。。。。。。。。。。。。。OK！");
    }

}
