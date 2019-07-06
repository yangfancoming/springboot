package com.goat.A.A04.item02;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/6---16:16
 */
/**
 * Builder.java
 *  建造者
 */
abstract class Builder {
    //地基
    abstract void bulidA();
    //钢筋工程
    abstract void bulidB();
    //铺电线
    abstract void bulidC();
    //粉刷
    abstract void bulidD();
    //完工-获取产品
    abstract Product getProduct();
}