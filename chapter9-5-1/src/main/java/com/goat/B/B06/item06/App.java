package com.goat.B.B06.item06;

/**
 * item05
 * 上面的实现，虽然能实现要求的功能，但是有一个很明显的问题：
 * 那就是必须区分组合对象和叶子对象，并进行有区别的对待，
 * 比如在 Node 和 App 类里面，都需要去区别对待这两种对象。
 * 区别对待组合对象和叶子对象，不仅让程序变得复杂，还对功能的扩展也带来不便。
 */
public class App {

    public static void main(String[] args) {
        //定义多个Composite对象
        Component root = new Composite();
        Component c1 = new Composite();
        Component c2 = new Composite();
        //定义多个叶子对象
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();

        //组合成为树形的对象结构
        root.addChild(c1);
        root.addChild(c2);
        root.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);

        //操作Component对象
        Component o = root.getChildren(1);
        System.out.println(o);

        root.someOperation();

    }

}
