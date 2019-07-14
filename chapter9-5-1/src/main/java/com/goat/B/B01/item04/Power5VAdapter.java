package com.goat.B.B01.item04;

import com.goat.B.B01.item02.AC220;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/14---11:59
 */
public class Power5VAdapter extends PowerAdapter {

    public Power5VAdapter(AC220 ac220) {
        super(ac220);
    }

    @Override
    public int output5V() {
        int output = mAC220.output220V() / 44;
        return output;
    }
}
