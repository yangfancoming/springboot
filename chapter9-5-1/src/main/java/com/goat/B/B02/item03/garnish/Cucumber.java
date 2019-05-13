package com.goat.B.B02.item03.garnish;

import com.goat.B.B02.item03.base.Pancake;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: 黄瓜丝
 * @ author  山羊来了
 * @ date 2019/5/13---9:19
 */
public class Cucumber extends Garnish {

    private Pancake pancake;

    public Cucumber(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 黄瓜丝";
    }

    @Override
    public double price() {
        return pancake.price() + 1.5;
    }
}
