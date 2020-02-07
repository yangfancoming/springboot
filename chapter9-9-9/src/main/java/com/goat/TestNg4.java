package com.goat;

import org.junit.Test;


public class TestNg4 {

    @Test
    public void test(){
        Object haha = haha(null, null);
        System.out.println(haha);
    }

    public Object haha(String value,Long def){
        return (value == null) ? def : 2; // modify-
    }

    @Test
    public void test2(){
        Object haha = haha2(null, null);
        System.out.println(haha);
    }

    public Object haha2(String value,Long def){
        if (value == null) {
            return def;
        } else {
            return Long.parseLong(value);
        }
    }

    @Test
    public void test3(){
        System.out.println(Long.parseLong(null));
    }
}
