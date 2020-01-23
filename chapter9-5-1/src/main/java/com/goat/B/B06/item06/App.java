package com.goat.B.B06.item06;

import org.junit.Test;

import java.util.List;

/**
 * item05
 * 上面的实现，虽然能实现要求的功能，但是有一个很明显的问题：
 * 那就是必须区分组合对象和叶子对象，并进行有区别的对待，
 * 比如在 Node 和 App 类里面，都需要去区别对待这两种对象。
 * 区别对待组合对象和叶子对象，不仅让程序变得复杂，还对功能的扩展也带来不便。
 *
 * 仔细分析上面不用模式的例子中，要区分组合对象和叶子对象的根本原因，就在于没有把组合对象和叶子对象统一起来，
 * 也就是说，组合对象类型和叶子对象类型是完全不同的类型，这导致了操作的时候必须区分它们。
 * 组合模式通过引入一个抽象的组件对象，作为组合对象和叶子对象的父对象，这样就把组合对象和叶子对象统一起来了，
 * 用户使用的时候，始终是在操作组件对象，而不再去区分是在操作组合对象还是在操作叶子对象。
 *
 *  Component 抽象父类 统一接口
 *  Node  容器节点
 *  Leaf  叶子节点
 */
public class App {

    @Test
    public void test(){
        //定义容器节点
        Component root = new Node("服装");
        Component node1 = new Node("男装");
        Component node2 = new Node("女装");
        // 给根容器节点 添加 容器节点
        root.addComponent(node1);
        root.addComponent(node2);

        //定义叶子节点
        Component leaf1 = new Leaf("衬衣");
        Component leaf2 = new Leaf("夹克");
        //  给容器节点 添加 叶子节点
        node1.addComponent(leaf1);
        node1.addComponent(leaf2);

        //定义叶子节点
        Component leaf3 = new Leaf("裙子");
        Component leaf4 = new Leaf("套装");
        //  给容器节点 添加 叶子节点
        node2.addComponent(leaf3);
        node2.addComponent(leaf4);

        //调用根对象的输出功能来输出整棵树
        root.businessLogic("");

        root.removeComponent(node1);
        root.businessLogic("");

        List<Component> list = node2.getList();
        System.out.println(list);

    }

}
