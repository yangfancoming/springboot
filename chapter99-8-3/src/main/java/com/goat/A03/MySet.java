package com.goat.A03;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/21---17:08
 *  * 1.Set 无序，不可重复
 */
public class MySet {
    Set<String> s = new HashSet<>();
    Set<String> ss = new TreeSet<>();
    @BeforeMethod
    public void testBefore() {
        s.add("周永康"); // 由于是 HashSet 集合 重复元素 将被忽略！
        s.add("周永康");
        s.add("孙悟空");
        s.add("三张");
        s.add("李四");
        s.add("王五");
        s.add("王五");
        System.out.println("----------------c---------------------");

        ss.add("A"); // 由于是 TreeSet 集合  集合的元素 将被自动排列  无法手动修改
        ss.add("B");
        ss.add("C");
        ss.add("E");
        ss.add("D");
        System.out.println("----------------c---------------------");
    }
    @Test
    public void HashSet(){  // 控制台的打印内容 可以看出 set集合是无序的！
        System.out.println(s);
        System.out.println(ss);
    }



}
