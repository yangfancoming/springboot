package com.goat.concurrency.system.queue;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;


@Component
public class MyConcurrentLinkedQueue {

    private ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue();

    /** 添加元素 */
    public void add(String s){
        concurrentLinkedQueue.add(s);
    }

    /** 取出元素 */
    public String poll(){
        return concurrentLinkedQueue.poll();
    }

}
