package com.goat.ds.singlelinkedlist;

import org.junit.Test;

/**
 * Created by 64274 on 2019/4/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/18---8:48
 */
public class App {

    SingleLinkedList sl = new SingleLinkedList();

    @Test
    public void test(){
        boolean empty = sl.isEmpty();
        System.out.println(empty);
    }

    @Test
    public void test1(){
        sl.addHead(11);
        sl.addHead("11");
        System.out.println(sl.isEmpty());
    }

    @Test
    public void test2(){
        sl.addHead(11);
        sl.addHead("22");
        sl.addHead(true);
        sl.display();
    }

    @Test
    public void test3(){
        sl.addHead(11);
        sl.display();
    }

    @Test
    public void test4(){
        Link all = new Link();
        all.add(5);
        all.add(6);
        all.add(7);
        all.add(8);
        all.add(9);
        System.out.println("链表长度:" + all.length());
        System.out.println("链表是否为空:" + all.isEmpty());
        System.out.println("链表查询数字9:" + all.contains(9));
        System.out.println("下标为“1”修改后数据:" + all.set(1, 20));
        System.out.println("获取下标为“1”的数据:" + all.get(1));
        all.remove(9);// 删除数据
        System.out.println("删除数据后链表长度:" + all.length());
        System.out.println("输出链表所有数据:");
        Link.print(all.toArray());
    }


}
