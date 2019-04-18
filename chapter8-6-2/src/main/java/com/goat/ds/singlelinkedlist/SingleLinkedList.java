package com.goat.ds.singlelinkedlist;

/**
 * Created by 64274 on 2019/4/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/18---8:46
 */
public class SingleLinkedList {
    private int size; //链表节点的个数
    private Node head;

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    private class Node{
        private   Object data; //每个节点的数据
        private Node next; //每个节点指向下一个节点的连接

        public Node(Object data){
            this.data = data;
        }
    }

    //在链表头部添加元素
    public Object addHead(Object obj){
        Node newhead = new Node(obj);
        if(size == 0){
            head = newhead;
        }else{
            newhead.next = head;
            head = newhead;
        }
        size++;
        return obj;
    }

    //在单链表头部进行删除
    public Object delHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找返回指定节点，找不到，返回Null
    public Node FindNode(Object obj){
        Node currnet = head;
        for(int i = 0; i < size; i++){
            if(obj.equals(currnet.data)){
                return currnet;
            }else{
                currnet = currnet.next;
            }
        }
        return null;
    }

    //删除指定元素，成功返回ture
    public boolean delete(Object obj){
        if(size == 0){
            return false;
        }

        Node current = head;
        Node previous = head;
        while(!current.data.equals(obj)){
            if(current.next == null){
                return false;
            }else{
                previous = current;
                current = current.next;
            }
        }

        //如果删除的节点是第一个节点
        if(current == head){
            head = current.next;
            size--;
        }else{
            //删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if(size > 0){
            Node node = head;
            int template = size;

            if(template == 1){
                System.out.println("[" + node.data + "]");
                return;
            }

            while(template > 0){
                if(node.equals(head)){
                    System.out.print("["+node.data + "->");
                }else if(node.next == null){
                    System.out.print(node.data + "]");
                }else{
                    System.out.print(node.data + "]");
                }
                node = node.next;
                template--;
            }
            System.out.println();
        }else{//如果聊表一个节点都没有，直接打印【】
            System.out.println("[]");
        }
    }
}

