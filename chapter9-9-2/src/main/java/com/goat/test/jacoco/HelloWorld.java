package com.goat.test.jacoco;


public class HelloWorld {
    public HelloWorld() {

    }

    public String testMethod1() {
        return "Hello World";
    }

    public int addMethod(int a, int b) {
        if (a > b) {
            int c = 5;
            System.out.print(c);
        }
        return a + b;
    }
}
