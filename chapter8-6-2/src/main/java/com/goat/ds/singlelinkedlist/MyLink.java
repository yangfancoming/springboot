package com.goat.ds.singlelinkedlist;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---9:49
 */
public class MyLink<E> {


    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" + "e=" + e + '}';
        }
    }

    private Node head;
    private int size;

    public MyLink() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    // 再链表头 添加新的元素
    public void addHead(E e){
        head = new Node(e,head);
        size++;
    }

}
