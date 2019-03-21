package com.goat.C.C05.example00;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

    private MyHandler h1 = new ConcrateHandler1();
    private MyHandler h2 = new ConcrateHandler2();
    private MyHandler h3 = new ConcrateHandler3();


    @BeforeMethod
    public void before(){
        h1.setSuccessor(h2).setSuccessor(h3);
    }
    @Test
    public void test0() {
        h1.handleRequest(11111); // 走三个节点
    }

    @Test
    public void test1() {
        h3.handleRequest(11111); // 只走最后一个节点
    }

    @Test
    public void test2() {
        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};
        for (int request : requests) {
            h1.handleRequest(request);
        }
    }


}
