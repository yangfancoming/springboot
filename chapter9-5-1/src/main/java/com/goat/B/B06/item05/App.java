package com.goat.B.B06.item05;

/**
 * Created by 64274 on 2019/7/17.
 *
 * @ Description: 不用设计模式的解决方案
 * @ author  山羊来了
 * @ date 2019/7/17---10:14
 *
 * 需求： 实现输出如下商品类别树的结构
 *
 * - 服装
 *     - 男装
 *         - 衬衣
 *         - 夹克
 *     - 女装
 *         - 裙子
 *         - 套装
 */
public class App {

    public static void main(String[] args) {
        //定义所有的组合对象
        Node root = new Node("服装");
        Node c1 = new Node("男装");
        Node c2 = new Node("女装");

        //定义所有的叶子对象
        Leaf leaf1 = new Leaf("衬衣");
        Leaf leaf2 = new Leaf("夹克");
        Leaf leaf3 = new Leaf("裙子");
        Leaf leaf4 = new Leaf("套装");

        //按照树的结构来组合组合对象和叶子对象
        root.addComposite(c1);
        root.addComposite(c2);
        c1.addLeaf(leaf1);
        c1.addLeaf(leaf2);
        c2.addLeaf(leaf3);
        c2.addLeaf(leaf4);

        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
    }
}
