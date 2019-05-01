package com.goat;

import org.junit.Test;


public class TestNg3 {

    @Test
    public void test() {

        int x = 105;
        int y = 50;
        int z = x%y;
        int z1 = x/y;
        System.out.println(z);
        System.out.println(z1);

    }



    @Test
    public void test1() {
        String aa = "aa";
        String bb = "bb";
        System.out.println(aa.equals(bb));
        System.out.println(aa==bb);
    }

    @Test
    public void test11() {
        String aa = "aa";
        String bb = "aa";
        System.out.println(aa.equals(bb));
        System.out.println(aa==bb);
    }

    @Test
    public void test2() {
        Long a = new Long(1l);
        Long b = new Long(1l);
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }

    @Test
    public void test3() {
        Long a = 1l;
        Long b = 1l;
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }


    @Test
    public void test4() {
        Long a = 1000l;
        Long b = 1000l;
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }


    @Test
    public void test5() {

        String a = "1";
        String b = null;
        System.out.println(a+b);

    }

}
