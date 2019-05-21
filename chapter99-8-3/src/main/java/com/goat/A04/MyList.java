package com.goat.A04;




import com.goat.model.Book;
import com.goat.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
     * @Description:
     * @author: 杨帆
     * @Date:  2018年12月26日18:52:32
*/
public class MyList {

    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    @Before
    public void before(){
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");
    }
    @Test
    public void test()  {
        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);
    }
    @Test
    public void test1()  {
        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);
    }
    @Test
    public void test2()  {
        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
        System.out.println("---差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);
    }
    @Test
    public void test3()  {
        // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEachOrdered(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEachOrdered(System.out :: println);
    }

    // 通过对象属性去重 distinctByKey()方法返回一个使用ConcurrentHashMap 来维护先前所见状态的 Predicate 实例，如下是一个完整的使用对象属性来进行去重的示例
    @Test
    public void distinctByKey1(){
        List<Person> list = new ArrayList(Arrays.asList(new Person("a",12),new Person("a",12),
                new Person("b",12),new Person("b",12)));
        list.stream().filter(distinctByKey(b -> b.getName() )) .forEach(b -> System.out.println(b.getName()+ "," + b.getId()));
    }

    @Test
    public void distinctByKey2(){
        List<Book> list = new ArrayList<>();{
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 300));
            list.add(new Book("Learning Freemarker", 150));
            list.add(new Book("Spring MVC", 200));
            list.add(new Book("Hibernate", 300));
        }
        list.stream().filter(distinctByKey(b -> b.getName())) .forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
