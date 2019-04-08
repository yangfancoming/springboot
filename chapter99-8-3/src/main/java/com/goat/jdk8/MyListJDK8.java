package com.goat.jdk8;



import com.goat.A04.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/21---19:18
 * Description:
 * java8新增加
 * void replaceAll(UnaryOperator operator) 根据指定规则重新设置List集合的所有元素
 * void  sort(Comparator c)                根据Comparator参数对List集合的元素排序，可以用 lambda 作为参数
 * sos List 三个子类的特点：
 * ArrayList ：
 * 1. 底层是数组 查改快   增删慢
 * 2. 因为线程不安全，所以效率高
 * Vector：
 * 1. 底层是数组 查改慢   增删慢
 * 2. 因为线程安全，所以效率低
 * LinkedList：
 * 1. 底层是双向链表  查改慢   增删快
 * 2. 因为线程不安全，所以效率高
 */
public class MyListJDK8 {
    List books = new ArrayList();
    List books2 = new ArrayList();
    List<Student> list = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    @BeforeMethod
    public void testBefore() {
        books.add("AA");
        books.add("DDDD");
        books.add("B");
        books.add("CCC");

        books2.add("{productiondate:YYWW}");
        books2.add("{productiondate:YYMMDD}");
        books2.add("{productiondate:YYYYMMDD}");
        books2.add("{productiondate:YYW%}");

        list.add(new Student(1,"zhangsan"));
        list.add(new Student(6,"zhangsan"));
        list.add(new Student(2,"zhangsan"));
        list.add(new Student(9,"zhangsan"));
        list.add(new Student(1,"zhangsan"));

        l.add(3);
        l.add(1);
        l.add(2);
        l.add(9);
        l.add(7);
    }

    @Test
    public void comparingInt(){
        // 使用目标类型为Comparator的 Lambda 表达式对List集合排序
        books.sort((o1, o2)->((String)o1).length() - ((String)o2).length());
        books.sort((o1, o2)->((String)o2).length() - ((String)o1).length());
        System.out.println(books);
    }
    @Test
    public void comparingInt2(){
        books2.sort(Comparator.comparingInt(o->((String) o).length())); // 按照 元素 长度 进行排序
        System.out.println(books2);
    }
    @Test
    public void comparingInt3(){
        books.sort(Comparator.comparingInt(o->((String) o).length())); // 按照 元素 长度 进行排序
        System.out.println(books);
    }
    @Test
    public void replaceAll(){
        // 使用目标类型为UnaryOperator的Lambda表达式来替换集合中所有元素
        // 该Lambda表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele->((String)ele).length());
        System.out.println(books); // 输出[7, 8, 11, 16]
    }
    @Test
    public void sort(){
        Collections.sort(l);//(从小到大)  12379
        System.out.println(l);
    }
    @Test
    public void reverse(){
        Collections.reverse(l);//(从大到 小)  79213
        System.out.println(l);
    }
    @Test
    public void naturalOrder(){
        list.sort(Comparator.naturalOrder());//正序比较 输出 11269
        //Collections.sort(list);// 正序比较
        for(Student i : list){
            System.out.println(i.getAge());
        }
    }
    @Test
    public void reverseOrder(){
        list.sort(Comparator.reverseOrder());// 反序比较  输出 96211
//        Collections.reverse(list);// 反序比较
        for(Student i : list){
            System.out.println(i.getAge());
        }
    }


    /**
     * Description:
     * 1，ArrayList 和 Vector类封装了一个动态的、允许再分配的Object[]数组
     * 2.使用initialCapacity设置数组长度。当需要添加大量元素可使用ensureCapacity(int minCapacity)一次性增加，提高性能
     * 3.初始大小10
     * 4.ArrayList线程不安全，如需要安全，可使用Collections的工具类。
     * 5.过时栈类Stack 替换 ArrayDeque
     * 6.操作数组的工具Arrays,Arrays.ArrayList是一个固定长度的List集合，只能遍历，不能增加删除。
     */
    @Test
    public void reverseO1rder(){
        List fixedList = Arrays.asList("疯狂Java讲义" , "轻量级Java EE企业应用实战");
        // 获取fixedList的实现类，将输出Arrays$ArrayList
        System.out.println(fixedList.getClass());
        // 使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);
        // 试图增加、删除元素都会引发UnsupportedOperationException异常
        fixedList.add("疯狂Android讲义");
        fixedList.remove("疯狂Java讲义");
    }
}


