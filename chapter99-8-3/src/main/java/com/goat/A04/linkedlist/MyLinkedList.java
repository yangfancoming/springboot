package com.goat.A04.linkedlist;



import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by 64274 on 2018/8/7.
 *
 * @author 山羊来了
 * @Description:  linkedList 作为 List 的子类 具有的特有功能
 * @date 2018/8/7---8:58
 *  LinkedList 特有功能
 *
 */
public class MyLinkedList {

    LinkedList linkedList = new LinkedList();
    @Before
    public void testBefore() {
        linkedList.add("周永康");
        linkedList.add("孙悟空");
        linkedList.add("三张");
        linkedList.add("李四");
        linkedList.add("王五");
        System.out.println("----------------c---------------------");
    }

    @Test
    public void add(){
        linkedList.addFirst("最前面？"); // 在集合第一个位置添加元素
        System.out.println(linkedList);
        linkedList.addLast("最后面？"); // 在集合最后一个位置添加元素
    }

    @Test
    public void getFirst(){ // 获取集合第一个元素   
        System.out.println(linkedList.getFirst());
    }

    @Test
    public void getLast(){ // 获取集合最后一个元素  
        System.out.println(linkedList.getLast());
    }

    @Test
    public void removeFirst(){ // 删除第一个元素  
        linkedList.removeFirst();
        System.out.println(linkedList);
    }

    @Test
    public void removeLast(){ // 删除最后一个元素  
        linkedList.removeLast();
        System.out.println(linkedList);
    }

    @Test
    public void test(){
        linkedList.remove(2);
        System.out.println(linkedList);
    }

    @Test
    public void test2(){
        linkedList.remove("李四");
        System.out.println(linkedList);
    }
}
