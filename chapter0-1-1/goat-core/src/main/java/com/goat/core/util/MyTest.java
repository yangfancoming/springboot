package com.goat.core.util;

import org.junit.Test;

/**
 * Created by 64274 on 2019/6/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/15---22:42
 */
public class MyTest {

    @Test
    public void test(){
        int a[] =   {1,2,4};
        Object b[] =   {1,2,4};
//                boolean empty = ArrayUtil.isEmpty(a);
//        boolean empty = ArrayUtil.isEmpty(b);
        boolean empty = ArrayUtil.isEmpty(null);
        System.out.println(empty);

    }
}
