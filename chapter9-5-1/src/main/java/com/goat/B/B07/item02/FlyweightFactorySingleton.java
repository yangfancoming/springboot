package com.goat.B.B07.item02;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @Description: 单例模式 享元
 * @author  山羊来了
 * @date 2019/5/13---13:27
 */
public class FlyweightFactorySingleton extends Factory {

    public FlyweightFactorySingleton(){}

    private static FlyweightFactorySingleton myself = new FlyweightFactorySingleton();

    public static FlyweightFactorySingleton getInstance() {
        return myself;
    }


}
