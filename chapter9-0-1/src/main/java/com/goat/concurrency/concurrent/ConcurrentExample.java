package com.goat.concurrency.concurrent;


import com.goat.concurrency.annoations.UnThreadSafe;
import com.goat.concurrency.common.BaseExample;
import org.junit.Test;


/** 并发模拟 工具类
 *
 * 可以看到 执行结果是错误的(4960,4993) 正确的结果应该是：5000
 * */

@UnThreadSafe
public class ConcurrentExample extends BaseExample {

    public static int count = 0;

    @Test
    public void test1() throws InterruptedException {
        test();
        System.out.println(count);
    }

    @Override
    public void add() {
       count++;
    }
}
