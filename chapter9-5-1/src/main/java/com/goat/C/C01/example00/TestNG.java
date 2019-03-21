package com.goat.C.C01.example00;


import org.testng.annotations.Test;



public class TestNG {

    @Test
    public void test() {
        Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }

}
