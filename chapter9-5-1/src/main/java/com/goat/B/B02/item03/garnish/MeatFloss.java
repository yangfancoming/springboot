package com.goat.B.B02.item03.garnish;

import com.goat.B.B02.item03.base.Pancake;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: 肉松
 * @ author  山羊来了
 * @ date 2019/5/13---9:18
 */
public class MeatFloss extends Garnish {

    private Pancake pancake;

    public MeatFloss(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 肉松";
    }

    @Override
    public double price() {
        return pancake.price() + 1.5;
    }

}
