package com.goat.hutool.cache;

import com.goat.hutool.cache.impl.TimedCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: LinkedHashMap
 * @ author  山羊来了
 * @ date 2019/5/13---14:48
 */
public class MyTest {

    Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
    Cache<String,String> fifoCache2 = CacheUtil.newFIFOCache(3,TimeUnit.SECONDS.toSeconds(2));

    @Test
    public void fifoCacheTest() throws InterruptedException {

        fifoCache.put("key1", "value1", TimeUnit.SECONDS.toSeconds(2));
        init();

        //由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
        System.out.println(fifoCache.get("key1"));

        TimeUnit.SECONDS.sleep(2); // 2秒 后 缓存自动清除
        System.out.println(fifoCache.get("key2"));
        System.out.println(fifoCache.get("key3"));
        System.out.println(fifoCache.get("key4"));
    }

    @Test
    public void test(){
        fifoCache2.put("key1", "value1", TimeUnit.SECONDS.toSeconds(2));
        System.out.println(fifoCache2.capacity());
    }


    Cache<String, String> lfuCache = CacheUtil.newLFUCache(3);
    @Test
    public void lfuCacheTest(){
        lfuCache.put("key1", "value1", TimeUnit.SECONDS.toSeconds(2));
        //使用次数+1
        lfuCache.get("key1");
        init();
        //由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最少使用的将被移除（2,3被移除）
        System.out.println(lfuCache.get("key2"));
        System.out.println(lfuCache.get("key3"));
    }


    Cache<String, String> lruCache = CacheUtil.newLRUCache(3);

    @Test
    public void lruCacheTest(){
        //通过实例化对象创建
        lruCache.put("key1", "value1", TimeUnit.SECONDS.toSeconds(2));
        lfuCache.put("key2", "value2", TimeUnit.SECONDS.toSeconds(2));
        lfuCache.put("key3", "value3", TimeUnit.SECONDS.toSeconds(2));
        //使用时间推近
        lruCache.get("key1");
        lruCache.put("key4", "value4", TimeUnit.SECONDS.toSeconds(2));

        Assert.assertNotNull(lruCache.get("key1"));
        Assert.assertNull(lruCache.get("key2")); //由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最少使用的将被移除（2被移除）
    }


    @Test
    public void timedCacheTest() throws InterruptedException {
        TimedCache<String, String> timedCache = CacheUtil.newTimedCache(4);
        timedCache.put("key1", "value1", 1);//1毫秒过期
        timedCache.put("key2", "value2", TimeUnit.SECONDS.toSeconds(5));//5秒过期
        timedCache.put("key3", "value3");//默认过期(4毫秒)
        timedCache.put("key4", "value4", Long.MAX_VALUE);//永不过期

        //启动定时任务，每5毫秒秒检查一次过期
        timedCache.schedulePrune(5);
        //等待5毫秒
        TimeUnit.SECONDS.sleep(5);

        //5毫秒后由于value2设置了5毫秒过期，因此只有value2被保留下来
        String value1 = timedCache.get("key1");
        Assert.assertTrue(null == value1);
        String value2 = timedCache.get("key2");
        Assert.assertEquals("value2", value2);

        //5毫秒后，由于设置了默认过期，key3只被保留4毫秒，因此为null
        String value3 = timedCache.get("key3");
        Assert.assertTrue(null == value3);

        // 永不过期
        String value4 = timedCache.get("key4");
        Assert.assertEquals("value4", value4);

        //取消定时清理
        timedCache.cancelPruneSchedule();
    }


    public void init() {
        lfuCache.put("key2", "value2", TimeUnit.SECONDS.toSeconds(2));
        lfuCache.put("key3", "value3", TimeUnit.SECONDS.toSeconds(2));
        lfuCache.put("key4", "value4", TimeUnit.SECONDS.toSeconds(2));
    }

}

