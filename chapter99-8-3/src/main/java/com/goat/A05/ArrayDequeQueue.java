package com.goat.A05;


import java.util.ArrayDeque;

/**
 * Description: FIFO,先进先出
 */
public class ArrayDequeQueue {

	public static void main(String[] args){
		ArrayDeque queue = new ArrayDeque();
		// 依次将三个元素加入队列
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");

		System.out.println(queue); // [a, b, c]
		System.out.println(queue.peek()); 	// 访问队列头部的元素，但并不将其poll出队列"栈"， 输出：a
		System.out.println(queue); // 依然输出：[a, b, c]
		System.out.println(queue.poll()); 	// poll出第一个元素，输出：a
		System.out.println(queue); // [b, c]
	}
}
