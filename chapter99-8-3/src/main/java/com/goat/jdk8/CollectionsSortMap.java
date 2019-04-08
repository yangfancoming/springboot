package com.goat.jdk8;

import com.goat.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by 64274 on 2019/4/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/8---15:38
 */
public class CollectionsSortMap {

    List<Map> list = new ArrayList<>();

    @Before
    public void before(){
        Map m1 = new HashMap<String, String>();
        m1.put("id", 1);
        m1.put("name", "刘备");
        Map m2 = new HashMap<String, String>();
        m2.put("id", 2);
        m2.put("name", "关羽");
        Map m3 = new HashMap<String, String>();
        m3.put("id",3);
        m3.put("name", "张飞");
        list.add(m2);
        list.add(m1);
        list.add(m3);
    }

    @Test
    public void test(){
        System.out.println("初始化=============");
        list.forEach(System.out::println);
        System.out.println("end");
        List<Map> result = process_intd(list, "id");
        System.out.println("result===================");
        result.forEach(System.out::println);

    }

    public static List<Map> process_intd(List<Map> data, final String arg) {
        List<Map> returnList = new ArrayList<>();
        Collections.sort(data, (o1, o2)-> (Integer) o1.get(arg) < (Integer) o2.get(arg) ? (o1 .get(arg) == o2.get(arg) ? 0 : -1) : 1);
        returnList.addAll(data);
        return returnList;
    }
    @Test
    public void test2(){
        System.out.println("初始化=============");
        list.forEach(System.out::println);
        System.out.println("result===================");
//        Collections.sort(list, (o1, o2)-> (Integer) o1.get("id") < (Integer) o2.get("id") ?  -1 : 1);
        Collections.sort(list, (o1, o2)-> (Integer) o1.get("id") < (Integer) o2.get("id") ?  1 : 1);
        list.forEach(System.out::println);
    }

    // doit 这里的  0 1 -1  到底有啥区别？
    @Test
    public void test1(){
        System.out.println("初始化=============");
        list.forEach(System.out::println);

        System.out.println("result=================== -1");
        Collections.sort(list, (o1, o2)-> -1);
        list.forEach(System.out::println);


        System.out.println("===================  1");
        Collections.sort(list, (o1, o2)-> 1);
        list.forEach(System.out::println);

        System.out.println("===================  0");
        Collections.sort(list, (o1, o2)-> 0);
        list.forEach(System.out::println);
    }


}
