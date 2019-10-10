package com.goat.B.B08.item02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 代码场景：中国移动有很多营销活动，而这些营销活动的对象是有要求的，有的需要判断在网时长，有的需要有最低套餐要求等；
 1.中国移动客户是目标角色；
 2.它不同营销活动的要求是过滤器角色；

 2.2 涉及角色
 过滤器模式包含如下两个角色：

 (1) AbstractFilter（抽象过滤器角色）：在客户端可以调用它的方法，在抽象过滤器角色中可以知道相关的（一个或者多个）子系统的功能和责任；在正常情况下，它将所有从客户端发来的请求委派到相应的实现类去，传递给相应的实现类对象处理。
 (2) ConcreteFilter（具体滤器角色）：在客户端可以调用它的方法，在具体滤器角色会对目标对象集合进行逻辑过滤，最后再返回一个过滤后的集合。
 (3) Subject（被过滤角色）：在软件系统中可以有一个或者多个目标角色，在具体过滤器中会对目标角色进行逻辑处理以查看是否是我想要的。

 */
public class App {

    Consumer zhangft = new Consumer("张奉天", 1, 5, 138);
    Consumer ruiBo = new Consumer("芮博", 5, 2, 238);
    Consumer zhongJj = new Consumer("仲军军", 10, 4, 1);

    List<Consumer> cs = Arrays.asList(zhangft,ruiBo,zhongJj);

    Filter broadbandFilter = new BroadbandFilter();
    Filter freeFlowFilter = new FreeFlowFilter();
    Filter birthdayRemindFilter = new BirthdayRemindFilter();

    @Test
    public void test1() {
        System.out.println("移动宽带免费一年用户:");
        List<Consumer> broadband = broadbandFilter.filtrate(cs);
        printList(broadband, "移动宽带");
    }

    @Test
    public void test2() {
        System.out.println("免费赠送移动流量用户:");
        List<Consumer> freeFlow = freeFlowFilter.filtrate(cs);
        printList(freeFlow, "流量10G");
    }

    @Test
    public void test3() {
        System.out.println("赠送生日提醒用户:");
        List<Consumer> birthdayRemind = birthdayRemindFilter.filtrate(cs);
        printList(birthdayRemind, "生日提醒功能");
    }

    private static void printList(List<Consumer> cs, String bussiness) {
        for (Consumer c : cs) {
            System.out.println("[" + c.getStar() + "]星级用户[" + c.getName()
                    + "],在网[" + c.getExistsYears() + "],当前套餐为[" + c.getCombos()
                    + "],免费赠送[" + bussiness + "]");
        }
    }


}
