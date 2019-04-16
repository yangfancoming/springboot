package com.goat.ds.linkedlist;

/**
 * Created by 64274 on 2019/4/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/15---13:10
 */
public class SingleLinkedList {

    //头结点
    private Node head;
    //尾节点
    private Node tail;
    //长度
    private int length;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }



    /**
     * 头部插入元素
     */
    public Node insertHead(String data) {
        Node node = new Node(data);
        Node lastNode;
        lastNode = head;
        head = node;
        head.next = lastNode;
        length++;
        return node;
    }

}
