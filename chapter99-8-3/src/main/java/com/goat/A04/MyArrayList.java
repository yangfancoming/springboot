package com.goat.A04;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/21---16:50
 *  Description: List 是Collection接口的子接口
 * 1.List 代表一个元素有序(输入和输出的元素顺序一致)、可重复的集合，都有索引(可使用数组访问方式)
 * 2.java8 改进的List接口和ListIterator接口
 * 3.java8 新增加 void replaceAll(UnaryOperator operator) 根据指定规则重新设置List集合的所有元素
 *                void  sort(Comparator c)                根据Comparator参数对List集合的元素排序，可以用lambda作为参数
 */
public class MyArrayList {
    ArrayList c = new ArrayList();
    ArrayList cc = new ArrayList();
    /**
     * 在执行目标测试方法testTest()前执行
     */
    @BeforeMethod
    public void testBefore() {
        c.add("周永康");
        c.add("孙悟空");
        c.add("三张");
        c.add("李四");
        c.add("李四");
        c.add("李四");
        c.add("王五");
        System.out.println("----------------c---------------------");

        cc.add("7");
        cc.add(8);
        cc.add(9);
        cc.add(10);
        cc.add(11);
        System.out.println("----------------cc---------------------");
    }
    @Test
    public void clear0(){
        c.clear();
        System.out.println(c) ;
    }

    @Test
    public void clear(){ // 按 下标 删除  返回删除的元素  fuck List作为Collection的子类 具有的特有功能  按索引删除元素 返回被删除的元素
        System.out.println(c.remove(1)) ;
    }
    @Test
    public void clear1(){ // 按 内容 删除  返回 是否删除成功
        System.out.println(c.remove("周永康"));
    }
    @Test
    public void clear4(){ // 按 下标 删除
        boolean fuck =  cc.remove( "7");
        System.out.println(fuck);
    }
    @Test
    public void clear2(){ // 按 内容 删除  sos（需要转成 Object ）
        cc.remove((Object) 7);
    }



    @Test
    public void add(){  // fuck List作为Collection的子类 具有的特有功能  在指定位置 添加元素
        // 将新字符串对象插入在第二个位置
        c.add(1, new String("疯狂Ajax讲义"));
    }
    @Test
    public void indexOf(){  // List作为Collection的子类 具有的特有功能  返回第一次出现指定元素的索引，如不包含此元素 则返回 -1
        // 判断指定元素在List集合中位置：输出1，表明位于第二位
        System.out.println(c.indexOf("王五"));
    }

    @Test
    public void get(){     // fuck List作为Collection的子类 具有的特有功能  获取指定位置的元素
        for (int i = 0; i < cc.size(); i++) {
            System.out.println(cc.get(i));
        }
        for(Object o:cc){
            System.out.println(o);
        }
    }
    @Test
    public void set(){  // fuck List作为Collection的子类 具有的特有功能  根据索引修改元素，返回被修改的元素
        // 将第二个元素替换成新的字符串对象
        c.set(1, "疯狂Java讲义");
    }
    @Test
    public void subList(){
        // 将books集合的第二个元素（包括） 到第三个元素（不包括）截取成子集合
        List temp = c.subList(1, 2); // fuck  subList 前端是闭区间(包括) 后端是开区间(不包括)
        System.out.println(temp);// 内容只有 孙悟空
    }

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
         * Description:  listIterator  迭代器 不通用 只有list系才能使用 使用正常遍历不推荐使用，推荐使用的是它的反向遍历功能！
         *  sos 但是 要想使用 listIterator 的反向遍历功能，必须先要正向遍历一遍。。。。。我凑！
         * 1.与Set只提供一个iterator()方法不同，List还额外提供了一个listIterator()方法，返回一个ListIterator对象
         * 2.ListIterator继承Iterator接口，额外提供
         * boolean hasPrevious() 返回迭代器集合是否还有上一个元素
         * Object previous()  返回上一个元素
         * void add(Object o) 在指定位置插入一个元素
         * @Date:   2018/7/21
    */
    @Test
    public void listiterator(){ // fuck List作为Collection的子类 具有的特有功能  列表迭代器
        ListIterator lit = c.listIterator();
        System.out.println("=======下面开始正向遍历=======");
        while (lit.hasNext()){
            System.out.println(lit.next()); // sos lit.set() lis.add() lis.remove() 在迭代器遍历中 必须使用 迭代器提供的 新增 删除 方法 不能使用集合 直接操作！
            lit.add("-------分隔符-------");
        }

        System.out.println("=======下面开始反向迭代======="); //
        while(lit.hasPrevious()){ // 判断前面是否还有元素
            System.out.println(lit.previous()); // 获取上一个元素后，指针上移一个元素
        }
    }

    @Test
    public void remove(){
        List books = new ArrayList();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");

        System.out.println(books);

        // 删除集合中A对象，将导致第一个元素被删除
        A a = new A();
        books.remove(a);     // ①
        System.out.println(books);

        // 删除集合中A对象，再次删除集合中第一个元素
        books.remove(new A());     // ②
        System.out.println(books);
    }
    @Test
    public void distinct1(){ //  ArrayList 集合去重方法   新建换一个临时集合方法
        ArrayList temp = new ArrayList();
        for (int i = 0; i < c.size(); i++) {
            String haha = (String) c.get(i);
            if(!temp.contains(haha)){ // 遍历元集合 如果在新集合中不包括的话  就添加到新的集合
                temp.add(haha);
            }
        }
        System.out.println(temp);

    }
    @Test
    public void distinct2(){ //  ArrayList 集合去重方法  不创建新集合  遍历发现重复就删
        for (int i = 0; i < c.size()-1; i++) {
            for (int j = i+1; j < c.size(); j++) {
                if(c.get(i).equals(c.get(j))){
                    c.remove(j);
                    j--;// sos 如果有删除 那么索引减1
                }
            }
        }
        System.out.println(c);
    }
}
