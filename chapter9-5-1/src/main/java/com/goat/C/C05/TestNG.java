package com.goat.C.C05;

import org.testng.annotations.Test;

public class TestNG {

    Handler h1 = new ConcrateHandler1();
    Handler h2 = new ConcrateHandler2();
    Handler h3 = new ConcrateHandler3();

    @Test
    public void test0() {
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h1.handleRequest(11111); // 走三个节点
    }

    @Test
    public void test1() {
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.handleRequest(11111); // 只走最后一个节点
    }

    @Test
    public void test2() {
        h1.setSuccessor(h2).setSuccessor(h3);
        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};
        for (int request : requests) {
            h1.handleRequest(request);
        }
    }


}
