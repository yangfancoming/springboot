package com.goat.B.B06;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/15---20:53
 */
public class Client {

    public static void main(String[] args) {

        //创建根节点对象
        Component component = new Composite("component");

        //创建两个组合节点对象
        Component composite1 = new Composite("composite1");
        Component composite2 = new Composite("composite2");

        //将两个组合节点对象添加到根节点
        component.add(composite1);
        component.add(composite2);

        //给第一个组合节点对象添加两个叶子节点
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        composite1.add(leaf1);
        composite1.add(leaf2);

        //给第二个组合节点对象添加一个叶子节点和一个组合节点
        Component leaf3 = new Leaf("leaf3");
        Component composite3 = new Composite("composite3");
        composite2.add(leaf3);
        composite2.add(composite3);

        //给第二个组合节点下面的组合节点添加两个叶子节点
        Component leaf4 = new Leaf("leaf4");
        Component leaf5 = new Leaf("leaf5");
        composite3.add(leaf4);
        composite3.add(leaf5);

        //执行所有节点的操作
        component.operation();
    }
}