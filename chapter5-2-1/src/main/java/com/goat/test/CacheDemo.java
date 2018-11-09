package com.goat.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2018/9/10.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/10---17:15
 */
public class CacheDemo {

    private static Cache<Object, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(100) // 设置缓存个数
            .expireAfterWrite(24, TimeUnit.HOURS) // 缓存项在创建后，在给定时间内没有被读/写访问，则清除。
            .expireAfterAccess(10, TimeUnit.MINUTES) // 缓存项在创建后，在给定时间内没有被写访问（创建或覆盖），则清除
            .recordStats() // 打开缓存统计功能
            .build();

    public static void put(Object key, Object value) {
        cache.put(key, value);
    }

    public static Object get(Object key) throws ExecutionException {
        Object var = cache.get(key, ()->{
            System.out.println("如果没有值,就执行其他方式去获取值");
            String var1 = "Google.com.sg";
            return var1;
        });
        return var;
    }
}

