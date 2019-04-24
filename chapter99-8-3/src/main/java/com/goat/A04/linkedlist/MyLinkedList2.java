package com.goat.A04.linkedlist;

import java.util.LinkedList;

/**
 * 1.属于List接口实现类
 * 2.实现Deque接口，可以被当成双端队列使用。因此也可以被当成栈来使用。
 *
 * 1.LinkedList、ArrayList、ArrayDeque实现机制完全不同
 * ArrayList、ArrayDeque内部以数组形式保存集合元素，随机访问集合元素性能好
 * LinkedList内部以链表保存集合元素，随机访问性能差，插入、删除元素性能出色，只改变指针所指向地址。
 *
 * 1.ArrayList.get()性能好
 * 2.LinkedList,采用迭代器Iterator遍历性能好
 */
public class MyLinkedList2 {

    public static void main(String[] args) {
        LinkedList books = new LinkedList();
        books.offer("疯狂Java讲义"); // 将字符串元素加入队列的尾部
        books.push("轻量级Java EE企业应用实战"); // 将一个字符串元素加入栈的顶部
        books.offerFirst("疯狂Android讲义"); // 将字符串元素添加到队列的头部（相当于栈的顶部）

        // 以List的方式（按索引访问的方式）来遍历集合元素
        for (int i = 0; i < books.size() ; i++ ){
            System.out.println("遍历中：" + books.get(i));
        }

        System.out.println(books.peekFirst());   // 访问、并不删除栈顶的元素
        System.out.println(books.peekLast()); // 访问、并不删除队列的最后一个元素
        System.out.println(books.pop());  // 将栈顶的元素弹出“栈”
        System.out.println(books); // 下面输出将看到队列中第一个元素被删除
        System.out.println(books.pollLast());  // 访问、并删除队列的最后一个元素
        System.out.println(books);  // 下面输出：[轻量级Java EE企业应用实战]
    }
}
