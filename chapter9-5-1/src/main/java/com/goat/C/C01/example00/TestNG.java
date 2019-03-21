package com.goat.C.C01.example00;


import org.testng.annotations.Test;



public class TestNG {

    @Test
    public void test() {

        Context context;
        Strategy strategyA = new ConcreteStrategyA();
        context = new Context(strategyA);
        context.contextInterface();

        Strategy strategyB = new ConcreteStrategyB();
        context = new Context(strategyB);
        context.contextInterface();

        Strategy strategyC = new ConcreteStrategyC();
        context = new Context(strategyC);
        context.contextInterface();
    }

}
