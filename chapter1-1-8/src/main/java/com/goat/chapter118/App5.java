package com.goat.chapter118;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: Ognl表达式中如何处理数组、集合和Map对象
 * @ author  山羊来了
 * @ date 2019/10/23---15:58
 */
public class App5 {


    @Test
    public void test3() throws OgnlException {
        OgnlContext context = new OgnlContext();

        // 通过Ognl表达式构建一个LinkedList对象，这注意：一定是包名+类名的形式
        Object list = Ognl.parseExpression("new java.util.LinkedList()");
        Object obj = Ognl.getValue(list, context, context.getRoot());
        System.out.println(obj);
        System.out.println("----------------------------");

        // 在Ognl中提供了一种类似数组索引的方式访问集合指定位置的元素
        // 下述例子直接构建了一个包含aa, bb, cc, dd四个元素的集合，然后访问集合中的第三个元素
        Object object15 = Ognl.getValue("{'aa', 'bb', 'cc', 'dd'}[2]", context, context.getRoot());
        System.out.println(object15);
        System.out.println("----------------------------");

        // 处理数组类型
        String[] strs = new String[] { "aa", "bb", "cc" };
        context.put("strs", strs);
        System.out.println(Ognl.getValue("#strs[1]", context, context.getRoot()));
        System.out.println("----------------------------");

        // 处理集合类型
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("hello world");
        context.put("words", words);
        System.out.println(Ognl.getValue("#words[0]", context, context.getRoot()));
        System.out.println("----------------------------");

        // 处理Map类型，注意的是为了与集合区分开，在大括号前面加"#"
        System.out.println(Ognl.getValue("#{'key1': 'value1', 'key2': 'value2', 'key3': 'value3', 'key4': 'value4'}['key3']",context, context.getRoot()));

    }

}
