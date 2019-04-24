package com.goat.A05;


import java.util.PriorityQueue;

/**
 * Description:
 * 调用peek  poll 方法取出队列中的元素时，并不取出最先进入队列的元素，而是取出最小的元素。 非FIFO
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		// 下面代码依次向pq中加入四个元素
		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);
		System.out.println(pq); // 输出 pq 队列，并不是按元素的加入顺序排列 输出[-3, 6, 20, 18]
		System.out.println(pq.poll()); // 访问队列第一个元素，其实就是队列中最小的元素：-3
	}
}
