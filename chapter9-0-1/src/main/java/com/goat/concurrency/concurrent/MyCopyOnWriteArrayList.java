package com.goat.concurrency.concurrent;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: CopyOnWriteArrayList  由 ArrayList 线程不安全 引出的新容器
 * @ author  山羊来了
 * @ date 2019/4/22---22:42
 * CopyOnWrite 容器 即写时复制容器。往一个容器添加元素时，并不直接往当前容器添加，而是现将当前容器进行拷贝，
 * 复制出一个新的容器 newElements ，并在往里添加元素，添加完后 再讲原容器的引用指向新的容器 setArray(newElements);
 * 这样做的好处是：可以对 CopyOnWrite 容器进行并发读！ 而不需要加锁，因为当前容器不会添加任何元素。
 * 所以 CopyOnWrite 也是一种读写分离的思想，即 读和写 分别操作不同的容器。
 */
public class MyCopyOnWriteArrayList {

    @Test
    public void test(){
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
//                List<String> list = new ArrayList<>();  /** ArrayList 线程不安全 */
//                List<String> list = new Vector<>();
//                List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <=30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    /**
     * 1. 异常报错： java.util.ConcurrentModificationException 并发修改异常
     * 2. 导致原因： 并发争抢修改list 导致 参考花名册签名情况
     * 3. 解决方案：
     *              1. 使用 new Vector<>();  因为：  点入源码可以看见 Vector 的 add() 方法加了 synchronized
     *              2. 使用 Collections.synchronizedList(new ArrayList<>());  将 ArrayList 变成线程安全的
     *              3. 使用 写时复制  推荐！
     * 4. 优化建议：
     *
     *

     */
}
