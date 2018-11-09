package com.goat.C.C01.example02;

/**
     * @Description: 用一个 ConcreteStrategy 来配置 维护一个对Strategy对象的引用
     * @author: 杨帆
     * @Date:   2018/11/5
*/
public class Context {
    Strategy strategy;

    //初始化时 传入具体的策略对象
    public Context(Strategy strategy) {
	this.strategy = strategy;
    }

    //根据具体的策略对象 调用其算法的方法
    public void contextInterface() {
	strategy.algorithmInterface();
    }

}