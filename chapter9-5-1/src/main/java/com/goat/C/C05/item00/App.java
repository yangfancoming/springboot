package com.goat.C.C05.item00;


import org.junit.Before;
import org.junit.Test;

public class App {

    private MyHandler h1 = new ConcrateHandler1();
    private MyHandler h2 = new ConcrateHandler2();
    private MyHandler h3 = new ConcrateHandler3();
    private MyHandler h4 = new ConcrateHandler4();


    @Before
    public void before(){
        h1.setSuccessor(h2).setSuccessor(h3).setSuccessor(h4);
    }


    @Test
    public void test0() {
        h1.handleRequest(11111); // 走三个节点
    }

    @Test
    public void test1() {
        h3.handleRequest(1); // 只走最后一个节点
    }

    @Test
    public void test2() {
        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};
        for (int request : requests) {
            h1.handleRequest(request);
        }
    }


}
