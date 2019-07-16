package com.goat.B.B02.item03.base;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: 手抓饼 和 肉夹馍 的父类 被装饰者
 * @ author  山羊来了
 * @ date 2019/5/13---9:03
 */
public abstract class Pancake {

    public String desc = "我不是一个具体的煎饼";

    public String getDesc() {
        return desc + price();
    }

    public abstract double price();

}