package com.goat.test.jacoco;


import junit.framework.Assert;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void testMethod1() {
        HelloWorld hw = new HelloWorld();
        String ss = hw.testMethod1();
        Assert.assertNotNull(ss);
    }

    @Test
    public void testMethod2() {
        HelloWorld hw = new HelloWorld();
        int ss = hw.addMethod(1, 1);
        Assert.assertEquals(ss, 2);
    }
}
