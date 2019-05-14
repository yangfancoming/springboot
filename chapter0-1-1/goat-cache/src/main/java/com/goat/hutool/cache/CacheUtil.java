package com.goat.hutool.cache;

import com.goat.hutool.cache.impl.FIFOCache;
import com.goat.hutool.cache.impl.LFUCache;
import com.goat.hutool.cache.impl.LRUCache;
import com.goat.hutool.cache.impl.TimedCache;

/**
 * 缓存工具类
 * @author Looly
 *@since 3.0.1
 */
public class CacheUtil {
	
	/**
	 * 创建FIFO(first in first out) 先进先出缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link FIFOCache}
	 */
	public static <K, V> FIFOCache<K, V> newFIFOCache(int capacity, long timeout){
		return new FIFOCache<>(capacity, timeout);
	}
	
	/**
	 * 创建FIFO(first in first out) 先进先出缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @return {@link FIFOCache}
	 */
	public static <K, V> FIFOCache<K, V> newFIFOCache(int capacity){
		return new FIFOCache<>(capacity);
	}


    /**
     * 创建LFU(least frequently used) 最少使用率缓存.
     *
     * @param <K> Key类型
     * @param <V> Value类型
     * @param capacity 容量
     * @return {@link LFUCache}
     */
    public static <K, V> LFUCache<K, V> newLFUCache(int capacity){
        return new LFUCache<>(capacity);
    }

    /**
     * 创建LRU (least recently used)最近最少使用.
     *
     * @param <K> Key类型
     * @param <V> Value类型
     * @param capacity 容量
     * @return {@link LRUCache}
     */
    public static <K, V> LRUCache<K, V> newLRUCache(int capacity){
        return new LRUCache<>(capacity);
    }



    /**
     * 创建定时缓存.
     *
     * @param <K> Key类型
     * @param <V> Value类型
     * @param timeout 过期时长，单位：毫秒
     * @return {@link TimedCache}
     */
    public static <K, V> TimedCache<K, V> newTimedCache(long timeout){
        return new TimedCache<>(timeout);
    }
}
