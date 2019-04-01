package com.goat.dp.strategy;

import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/28---18:38
 */
@Component
public class VIPStrategyImpl implements IDiscountStrategy {

    @Override
    public String type() {
        return "VIP";
    }

    @Override
    public Double discount(Double price) {
        return  price * 0.65;
    }
}
