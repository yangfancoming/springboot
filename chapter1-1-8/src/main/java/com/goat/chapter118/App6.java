package com.goat.chapter118;

import com.goat.chapter118.model.Student;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: Ognl中的过滤和投影两个概念
 * @ author  山羊来了
 * @ date 2019/10/23---15:58
 *
 * 无论过滤还是投影都是针对于数组、集合和Map而言的；
 *
 * 过滤指的是将原集合中不符合条件的对象过滤掉，然后将满足条件的对象，构建一个新的集合对象返回，Ognl过滤表达式的写法是：collection.{?|^|$ expression}；
 *
 * 投影指的是将原集合中所有对象的某个属性抽取出来，单独构成一个新的集合对象返回，基础语法为 ：collection.{expression}；

 */
public class App6 {


    @Test
    public void test1() throws OgnlException {
        Student s1 = new Student("Tom", 22, 170.3);
        Student s2 = new Student("Jack", 21, 176.2);
        Student s3 = new Student("Tomas", 23, 180.1);
        Student s4 = new Student("Lucy", 20, 163.3);

        List<Student> stus = new ArrayList<>();
        Collections.addAll(stus, s1, s2, s3, s4);
        // 新建OgnlContext对象
        OgnlContext context = new OgnlContext();
        context.put("stus", stus);

        // 过滤（filtering）,collection.{? expression}
        // 利用过滤获取身高在175以上的所有学生集合
        // 输出结果：[Student [name=Jack, age=21, height=176.2], Student [name=Tomas, age=23, height=180.1]]
        System.out.println(Ognl.getValue("#stus.{? #this.height > 175.0}", context, context.getRoot()));

        // 过滤（filtering）,collection.{^ expression}
        // 利用过滤获取身高在175以上的所有学生集合中第一个元素
        // 输出结果：[Student [name=Jack, age=21, height=176.2]]
        System.out.println(Ognl.getValue("#stus.{^ #this.height > 175.0}", context, context.getRoot()));

        // 过滤（filtering）,collection.{$ expression}
        // 利用过滤获取身高在175以上的所有学生集合的最后一个元素
        // 输出结果：[Student [name=Tomas, age=23, height=180.1]]
        System.out.println(Ognl.getValue("#stus.{$ #this.height > 175.0}", context, context.getRoot()));

        // 投影（projection）, collection. {expression}
        // 获取集合中的所有学生的姓名
        // 输出结果：[Tom, Jack, Tomas, Lucy]
        System.out.println(Ognl.getValue("#stus.{name}", context, context.getRoot()));

    }


    @Test
    public void test2() throws OgnlException {


    }
}
