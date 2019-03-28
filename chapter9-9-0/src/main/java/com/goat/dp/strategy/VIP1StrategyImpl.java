package com.goat.dp.strategy;

import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/28---18:38
 */
@Service
public class VIP1StrategyImpl implements IDiscountStrategy {

    @Override
    public String type() {
        return "VIP1";
    }

    @Override
    public Double discount(Double price) {
        return  price * 0.75;
    }
}
