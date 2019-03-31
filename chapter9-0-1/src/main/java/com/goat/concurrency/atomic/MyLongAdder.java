package com.goat.concurrency.atomic;

import com.goat.concurrency.annoations.ThreadSafe;
import com.goat.concurrency.common.BaseExample;
import org.junit.Test;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by 64274 on 2019/3/31.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/31---22:41
 */
@ThreadSafe
public class MyLongAdder extends BaseExample {

    private static LongAdder count = new LongAdder(); // 默认是0

    @Test
    public void test1() throws InterruptedException {
        test();
        System.out.println(count);
    }

    @Override
    public void add() {
        count.increment(); // 默认加1
    }
}
