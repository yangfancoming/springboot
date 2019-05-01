package com.goat.A03;




import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: Set 接口中没有定义新的方法 使用的都是 Collection 接口中声明过的方法
 * 无序性： 不等于随机性 （每次遍历的结果都是一样的） 无序性指的是 按照顺序存入的两个元素的内存地址并不连续
 * 不可重复性： 由于底层实现 是数据+ 链表实现   每添加一个元素计算出其 hashcode 根据 hashcode 放置到数组的某个位置  每次add()时 都判断对应的hashcode位置
 * 是否已经存有元素 如果没有则 直接添加 如果有则再调用 equals() 方法如果返回true 则表明是重复元素 直接忽略 如果返回false则 添加到链表中
 * 为什么要使用这种算法呢？ 因为 添加到1000个元素的时候 要判断第1000个元素 是否与前面999个元素相同 这样的话 效率会很低。
 * @date 2018/7/21---17:08
 *  * 1.Set 无序，不可重复
 */
public class MySet {
    Set s = new HashSet<>();
    Set<String> ss = new TreeSet<>();
    @Before
    public void testBefore() {
        s.add(456);
        s.add(123);
        s.add("AA");
        s.add("CC");
        s.add(129);
        System.out.println("----------------c---------------------");

        ss.add("A"); // 由于是 TreeSet 集合  集合的元素 将被自动排列  无法手动修改
        ss.add("B");
        ss.add("C");
        ss.add("E");
        ss.add("D");
        System.out.println("----------------c---------------------");
    }
    @Test
    public void HashSet(){  // [AA, CC, 129, 456, 123]  由于是 HashSet 集合 重复元素 将被忽略！
        System.out.println(s);
    }



}
