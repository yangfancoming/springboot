package com.goat.A04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/10/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/8---11:13
 */
public class BaseListData {

    public List<String> list1 = new ArrayList<>();
    public List<String> list2 = new ArrayList<>();


    public ArrayList c = new ArrayList();
    public  ArrayList cc = new ArrayList();


    public BaseListData() {

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");


        c.add("周永康");
        c.add("孙悟空");
        c.add("三张");
        c.add("李四");
        c.add("李四");
        c.add("李四");
        c.add("王五");
        System.out.println("----------------c---------------------");

        cc.add("7");
        cc.add(8);
        cc.add(9);
        cc.add(10);
        cc.add(11);
        System.out.println("----------------cc---------------------");
    }
}
