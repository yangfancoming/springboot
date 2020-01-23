package com.goat.B.B06.item12;

import org.junit.Test;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---17:03
 *
 * 下面给出一个例子来说明，曾经我做项目的时候，遇到过这样的一种需求，
 * 计算某个学生的分数，但是这个分数由A，B，C三部分组成，它们的比重分别为0.3,   0.4,  0.3，
 * 而A又由a1(0.5),a2(0.5),B又由b1(0.3),b2(0.7),C又由c1(0.4),c2(0.6)组成括号后面代表各自所占得比重，
 * 最后a1,a2,b1,b2,c1,c2的成绩分别为80,70,95,87,78,63。求这个学生的分数
 */
public class App {

    @Test
    public void tst(){
        Composite root = new Composite(1);

        Composite A = new Composite(0.3);
        Composite B = new Composite(0.4);
        Composite C = new Composite(0.3);

        Composite a1 = new Composite(0.5);
        a1.add(new Leaf(80));
        Composite a2 = new Composite(0.5);
        a2.add(new Leaf(70));
        A.add(a1);
        A.add(a2);

        Composite b1 = new Composite(0.3);
        b1.add(new Leaf(95));
        Composite b2 = new Composite(0.7);
        b2.add(new Leaf(87));
        B.add(b1);
        B.add(b2);

        Composite c1 = new Composite(0.4);
        c1.add(new Leaf(78));
        Composite c2 = new Composite(0.6);
        c2.add(new Leaf(63));
        C.add(c1);
        C.add(c2);

        root.add(A);
        root.add(B);
        root.add(C);
        System.out.println(root.calcScore());
        /**
         * 当然结果没有格式化，会稍有小数位的误差。
         *
         * 总结：这种实现方式只是组合模式的安全式的实现，而且是自上向下的，即父节点能够得到子节点的引用，
         * 该程序只要稍微改改就能让它也具有自下向上的功能，即子节点也可以得到父节点的引用，
         * 只要在Componet中加一个getParent,setParent方法，然后树枝添加树叶的时候，
         * 树叶调用setParent(this)即可，树枝删除树叶的时候，树叶调用setParent(null)即可。
        */
    }
}
