package com.goat.jdk8;

import com.goat.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 64274 on 2019/4/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/8---15:38
 */
public class CollectionsSortList {

    List<Student> list = new ArrayList<>();

    @Before
    public void before(){
        list.add(new Student(1,25,"关羽"));
        list.add(new Student(2,21,"张飞"));
        list.add(new Student(3,18,"刘备"));
        list.add(new Student(4,32,"袁绍"));
        list.add(new Student(5,36,"赵云"));
        list.add(new Student(6,16,"曹操"));
        System.out.println("排序前:");
        list.forEach(System.out::println);
    }

    @Test
    public void test(){
        Collections.sort(list);   //使用默认排序
        System.out.println("默认排序后:");
        list.forEach(System.out::println);
    }

    @Test
    public void test1(){
        //自定义排序 正序
        Collections.sort(list, Comparator.comparingInt(Student::getId));
        list.forEach(System.out::println);

        System.out.println("---------------:");

        //自定义排序 反序
        Collections.sort(list, (o1, o2)->o2.getId() - o1.getId());
        list.forEach(System.out::println);
    }

    // doit 这里的  0 1 -1  到底有啥区别？
    @Test
    public void test2(){
        System.out.println("---------------:");
        Collections.sort(list, (o1, o2)->1);
        System.out.println("---------------:");
        list.forEach(System.out::println);
        Collections.sort(list, (o1, o2)->0);
        System.out.println("---------------:");
        list.forEach(System.out::println);
        Collections.sort(list, (o1, o2)->-1);
        System.out.println("---------------:");
        list.forEach(System.out::println);
    }

}
