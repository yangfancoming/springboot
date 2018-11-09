package com.goat.C.C01.example02;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 封装了集体的算法和行为 继承于Strategy
 * @date 2018/11/5---9:25
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("策略B的具体算法实现");
    }
}
