package cn.goatool.core.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/8/28---15:04
 */
public class ListUtilsTest {

    public static List<Object> list = new ArrayList<>(10);

    public static void init(){
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
    }

    /**
     * [a, b, c]
     * [d, e, f]
     * [h, i, j]
     * [k]
    */
    @Test
    public void test(){
        init();
        ListUtils.dealBySubList(list,3);
    }
}
