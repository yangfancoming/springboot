package com.goat.A04;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

/**
 * Created by 64274 on 2018/8/7.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/7---8:58
 *  LinkedList 特有功能
 *
 */
public class MyLinkedList {

    LinkedList linkedList = new LinkedList();
    @BeforeMethod
    public void testBefore() {
        linkedList.add("周永康");
        linkedList.add("孙悟空");
        linkedList.add("三张");
        linkedList.add("李四");
        linkedList.add("王五");
        System.out.println("----------------c---------------------");
    }

    @Test
    public void addFirst(){ // 在集合第一个位置添加元素   fuck linkedList 作为 List 的子类 具有的特有功能
        linkedList.addFirst("纳尼1？");
        System.out.println(linkedList);
    }

    @Test
    public void addLast(){ // 在集合最后一个位置添加元素   fuck linkedList 作为 List 的子类 具有的特有功能
        linkedList.addLast("纳尼2？");
        System.out.println(linkedList);
    }

    @Test
    public void getFirst(){ // 获取集合第一个元素   fuck linkedList 作为 List 的子类 具有的特有功能
        System.out.println(linkedList.getFirst());
    }

    @Test
    public void getLast(){ // 获取集合最后一个元素   fuck linkedList 作为 List 的子类 具有的特有功能
        System.out.println(linkedList.getLast());
    }

    @Test
    public void removeFirst(){ // 删除第一个元素   fuck linkedList 作为 List 的子类 具有的特有功能
        linkedList.removeFirst();
        System.out.println(linkedList);
    }

    @Test
    public void removeLast(){ // 删除最后一个元素   fuck linkedList 作为 List 的子类 具有的特有功能
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
