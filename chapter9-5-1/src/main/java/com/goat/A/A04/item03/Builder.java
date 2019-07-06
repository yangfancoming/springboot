package com.goat.A.A04.item03;

/**
 * Created by 64274 on 2019/7/6.
 * @ Description: 建造者
 * @ author  山羊来了
 * @ date 2019/7/6---16:20
 */

abstract class Builder {
    //汉堡
    abstract Builder bulidA(String mes);
    //饮料
    abstract Builder bulidB(String mes);
    //薯条
    abstract Builder bulidC(String mes);
    //甜品
    abstract Builder bulidD(String mes);
    //获取套餐
    abstract Product build();
}
