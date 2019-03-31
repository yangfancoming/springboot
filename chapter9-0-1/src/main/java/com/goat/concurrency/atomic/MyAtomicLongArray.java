package com.goat.concurrency.atomic;

import com.goat.concurrency.annoations.ThreadSafe;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Created by 64274 on 2019/3/31.
 *
 * @ Description:
 * @ author  山羊来了
 * @ date 2019/3/31---22:41
 */
@ThreadSafe
public class MyAtomicLongArray {

    final Logger log = LoggerFactory.getLogger(getClass());

    private static AtomicLongArray array = new AtomicLongArray(new long[]{10, 20, 30, 40, 50});

    @Test
    public void test1()  {
        array.set(0, 100);
        for (int i = 0, len = array.length(); i < len; i++) {
            log.info("get({}) : {}", i, array.get(i));
        }
        log.info("getAndDecrement(0):{}", array.getAndDecrement(0));
        log.info("decrementAndGet(1):{}", array.decrementAndGet(1));
        log.info("getAndIncrement(2):{}", array.getAndIncrement(2));
        log.info("incrementAndGet(3):{}", array.incrementAndGet(3));

        log.info("addAndGet(100):{}", array.addAndGet(0, 100));
        log.info("getAndAdd(100):{}", array.getAndAdd(1, 100));

        log.info("compareAndSet():{}", array.compareAndSet(2, 31, 1000));
        log.info("get(2):{}", array.get(2));
    }

}
