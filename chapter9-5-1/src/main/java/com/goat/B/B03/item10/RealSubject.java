package com.goat.B.B03.item10;


public class RealSubject implements Subject {

    @Override
    public int sellBooks() {
        System.out.println("卖书");
        return 100;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "张三";
    }
}
