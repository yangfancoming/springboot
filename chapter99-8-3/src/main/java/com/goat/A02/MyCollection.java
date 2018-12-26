package com.goat.A02;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by 64274 on 2018/6/25.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/6/25---14:31
 *
 * Collection
 * 1.Set 无序，不可重复
 * 2.List 有序，可重复
添加功能：
 *  boolean add(Object o)添加对象到集合
 *  boolean addAll(Collection c)将集合c中所有的元素添加给该集合
 *
 删除功能：
    boolean remove(Object o)删除指定的对象
    void clear()删除集合中所有元素
    void removeAll(Collection c)从集合中删除c集合中也有的元素
    void retainAll(Collection c)从集合中删除集合c中不包含的元素

判断功能：
    int size()返回当前集合中元素的数量
    boolean contains(Object o)查找集合中是否有指定的对象
    boolean isEmpty()判断集合是否为空
    boolean containsAll(Collection c)查找集合中是否有集合c中的元素

遍历功能：
    Iterator iterator()返回一个迭代器



 */
public class MyCollection
{
    Collection c = new ArrayList();
    Collection books = new HashSet();

    /**
     * 在执行目标测试方法testTest()前执行
     */
    @BeforeMethod
    public void testBefore() {
        c.add(true);
        c.add(123);
        c.add("周永康");
        c.add("孙悟空");
        System.out.println("-------------------------------------");
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        System.out.println("-------------------------------------");
    }
    @Test
    public void add(){
        System.out.println("添加成功吗？"+c.add("郭美美"));
        System.out.println("c集合的元素个数为:" + c.size());
        Collection dd = new ArrayList();
        String temp = "123";
        ArrayList haha = new ArrayList();
        dd.add(temp);
        dd.add(haha);
        System.out.println(haha);
    }

    @Test
    public void clear(){
        //清空集合中的所有元素
        c.clear();
        System.out.println("c集合的元素个数为:" + c.size());
    }
    @Test
    public void remove(){
        // 删除 内容匹配的第一项
        c.remove("孙悟空");
        c.remove(123);
        c.remove(110);
        System.out.println("c集合的元素个数为:" + c.size());
    }
    @Test
    public void removeAll(){
        // 用c集合减去books集合里的元素
        books.add(true);
        c.removeAll(books);
        System.out.println("c集合的元素：" + c);
    }

    @Test
    public void contains(){
        // 判断是否包含指定字符串
        System.out.println("c集合的是否包含孙悟空字符串:" + c.contains("孙悟空"));
    }
    @Test
    public void containsAll(){
        books.clear();
        books.add(true);
        books.add(123);
        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books)); // 输出false
    }

    // doit
    @Test
    public void contain1sAll(){
//        List<Map<Object, Object>> list1 = new ArrayList<>();
//        List<Map<Object, Object>> list2 = new ArrayList<>();
//        list1.stream()
//                .filter(map -> list2.stream().anyMatch(map1 -> map.get("id").equals(map1.get("id"))))
//                .forEach(map -> {
//                    // to do sth
//                });
    }
    @Test
    public void contain21sAll(){
//        List<User> list1 = new ArrayList<>();
//        List<User> list2 = new ArrayList<>();
//        list1.stream()
//                .filter(map -> list2.stream().anyMatch(map1 -> map.getName().equals(map1.get("id"))))
//                .forEach(map -> {
//                    // to do sth
//                });
    }
    @Test
    public void addAll(){
        c.addAll(books);// 将books集合添加到c集合中 （允许有重复值）
        System.out.println(c);

    }
    @Test
    public void retainAll(){
        // 控制books集合里只剩下c集合里也包含的元素,交集。
        books.add(123);
        books.retainAll(c); // 取两个集合中的交集  其返回值表示 原集合在取交集操作后，原集合是否发生变化 有变化返回true 无变化返回false
        System.out.println("books集合的元素:" + books);
    }
    @Test
    public void forEach(){
        // 控制books集合里只剩下c集合里也包含的元素,交集。
        books.forEach(obj -> System.out.println("books迭代集合元素：" + obj));
        c.forEach(obj -> System.out.println("c迭代集合元素：" + obj));
    }

    @Test
    public void toArray(){
        // list 转数组
        Object[] haha = c.toArray();
        for (int i = 0; i <c.size() ; i++) {
            System.out.println(haha[i].toString().length()+"--------" + haha[i]);
        }
    }

    @Test
    public void Iterator(){
        Iterator it = c.iterator(); // 通过迭代器高效遍历元素
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
         * @Param:   it.next()  获取元素 并将指针移动到下一个元素位置
         * @Return:  需要注意的是  it.next() 执行一次 指针就移动一次 在循环中 要特别注意
         * @Date:   2018/8/6
    */
    @Test
    public void Iterator2(){
        Iterator it = c.iterator();
        while (it.hasNext()){
            String mark = it.next().toString();
            if(mark.equals("周永康")){
                it.remove();// 通过迭代器 删除  集合中的元素
//                c.remove("周永康");// sos 这里千万注意  再迭代器循环中 删除元素 必须使用 迭代器删除 不能直接使用集合的删除方法 否则 报错！
            }
            else {
                System.out.println(mark);
            }
        }
    }
}
