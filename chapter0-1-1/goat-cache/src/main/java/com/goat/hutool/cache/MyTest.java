package com.goat.hutool.cache;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/13---14:48
 */
public class MyTest {

    @Test
    public void test(){
        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        fifoCache.put("key1", "value1", TimeUnit.SECONDS.toSeconds(2));
        fifoCache.put("key2", "value2", TimeUnit.SECONDS.toSeconds(2));
        fifoCache.put("key3", "value3", TimeUnit.SECONDS.toSeconds(2));
        fifoCache.put("key4", "value4", TimeUnit.SECONDS.toSeconds(2));

        //由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
        System.out.println(fifoCache.get("key1"));
        System.out.println(fifoCache.get("key2"));
        System.out.println(fifoCache.get("key3"));
        System.out.println(fifoCache.get("key4"));
    }
}

