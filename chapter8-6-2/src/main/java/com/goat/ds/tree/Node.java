package com.goat.ds.tree;

/**
 * Created by 64274 on 2019/5/15.
 *
 * @ Description: 二叉树的节点类
 * @ author  山羊来了
 * @ date 2019/5/15---13:54
 */
public class Node {
    int data;   //节点数据
    Node leftChild; //左子节点的引用
    Node rightChild; //右子节点的引用
    boolean isDelete;//表示节点是否被删除

    public Node(int data){
        this.data = data;
    }

    public void display(){     //打印节点内容
        System.out.println(data);
    }

}