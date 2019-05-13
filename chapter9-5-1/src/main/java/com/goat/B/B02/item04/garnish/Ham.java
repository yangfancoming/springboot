package com.goat.B.B02.item04.garnish;


import com.goat.B.B02.item04.base.Pancake;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/13---9:45
 */
public class Ham implements Garnish {

    private Pancake pancake;

    public Ham(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "火腿";
    }

    @Override
    public double price() {
        return pancake.price() + 1.5;
    }
}
