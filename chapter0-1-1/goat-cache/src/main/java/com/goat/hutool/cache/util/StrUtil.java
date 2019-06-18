package com.goat.hutool.cache.util;

import org.junit.Test;

/**
 * Created by 64274 on 2019/6/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/18---17:20
 */
public class StrUtil {


    @Test
    public void test(){
        String name="weicc-20100107-00001";
        System.out.println(name.substring(name.length()-5));//输出 00001
        System.out.println(name.substring(name.length()-3));//输出 001
    }
}
