package com.goat.A05;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Description: FIFO,先进先出
 *
 * ArrayDeque不是线程安全的。
 * ArrayDeque不可以存取null元素，因为系统根据某个位置是否为null来判断元素的存在。
 * 当作为栈使用时，性能比Stack好；当作为队列使用时，性能比LinkedList好。
 */
public class ArrayDequeQueue {

    ArrayDeque queue = new ArrayDeque();

	@Before
    public void  before(){
        // 依次将三个元素加入队列
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
    }


	@Test
    public void test1(){
        System.out.println(queue); // [a, b, c]
        System.out.println(queue.peek()); 	// 访问队列头部的元素，但并不将其poll出队列"栈"， 输出：a
        System.out.println(queue); // 依然输出：[a, b, c]
        System.out.println(queue.poll()); 	// poll出第一个元素，输出：a
        System.out.println(queue); // [b, c]
    }

    @Test
    public void test2(){
        queue.addFirst("addFirst");
        queue.addLast("addLast");
        // [addFirst, a, b, c, addLast]
        System.out.println(queue);
    }

    @Test
    public void test3(){
        queue.removeFirst();
        queue.removeLast();
        // [b]
        System.out.println(queue);
    }

    @Test
    public void test4(){
        Object first = queue.getFirst();
        Object last = queue.getLast();
        System.out.println(first);
        System.out.println(last);
    }

    @Test
    public void test5(){
        System.out.println("初始队列：" + queue);
	    //  push(E e) 栈顶添加一个元素
        queue.push("push");
        System.out.println("push后：" + queue);
        //   pop(E e) 移除栈顶元素,如果栈顶没有元素将抛出异常
        Object pop = queue.pop();
        System.out.println("pop后：" + queue);
        System.out.println(pop);
        System.out.println("最终队列“" + queue);
    }

    @Test
    public void test6(){
        System.out.println("初始队列：" + queue);
        Object pop = queue.pop();
        System.out.println("pop后：" + queue);
        System.out.println(pop);
        queue.add(pop);
        System.out.println("add后：" + queue);
        System.out.println("最终队列：" + queue);
    }
}
