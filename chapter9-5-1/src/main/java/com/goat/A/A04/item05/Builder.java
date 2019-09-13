package com.goat.A.A04.item05;

/**
 * Created by 64274 on 2019/8/5.
 *
 * @ Description: 抽象建造类，确定产品由两个部件PartA和PartB组成， 并声明一个得到产品建造后结果的方法getResult
 * @ author  山羊来了
 * @ date 2019/8/5---9:33
 */
public abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getResult();
}
