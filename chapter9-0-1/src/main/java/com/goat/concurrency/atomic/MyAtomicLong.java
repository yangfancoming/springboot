package com.goat.concurrency.atomic;


import com.goat.concurrency.annoations.ThreadSafe;
import com.goat.concurrency.common.BaseExample;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class MyAtomicLong extends BaseExample {

    private static AtomicLong count = new AtomicLong(0);

    @Test
    public void test1() throws InterruptedException {
        test();
        System.out.println(count.get());
    }

    @Override
    public void add() {
        count.incrementAndGet();
    }

}
