package com.goat.core.util;


import org.junit.Assert;
import org.junit.Test;


/**
 * {@link ArrayUtil} 数组工具单元测试
 * 
 * @author Looly
 *
 */
public class StrUtilTest {

    // 原生 jdk 方法  从后面开始截取
    @Test
    public void test(){
        String name="weicc-20100107-00001";
        System.out.println(name.substring(name.length()-5));//输出 00001
        System.out.println(name.substring(name.length()-3));//输出 001
    }



    @Test
    public void test1(){

        // 从头开始截取
        Assert.assertEquals("goa",StrUtil.sub("goat-110", 0, 3));
        // 从中间开始截取
        Assert.assertEquals("at",StrUtil.sub("goat-110", 2, 4));
        Assert.assertEquals("",StrUtil.sub("goat-110", 2, 2));
        Assert.assertEquals("",StrUtil.sub("goat-110", 2, 2));
    }

}
