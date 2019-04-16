package com.goat.ds.linkedlist;

/**
 * Created by 64274 on 2019/4/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/15---13:05
 */
public class Node {

    //存放数据的变量，简单点，直接为int型
    public Object data;
    //存放结点的变量
    public Node next;

    //构造方法，在构造时就能够给data赋值
    public Node(Object data){
        this.data = data;
    }
}
