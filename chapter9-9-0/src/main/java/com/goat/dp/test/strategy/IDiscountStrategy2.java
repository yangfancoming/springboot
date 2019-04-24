package com.goat.dp.test.strategy;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: 打折策略
 * @ author  山羊来了
 * @ date 2019/3/28---18:36
 */
public interface IDiscountStrategy2 {

    // 客户类型 VIP VIP1 VIP2
    String type();

    // 打折计算方法
    Double discount(Double price);
}
