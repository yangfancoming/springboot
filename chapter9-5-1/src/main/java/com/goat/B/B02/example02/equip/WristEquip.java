package com.goat.B.B02.example02.equip;

import com.goat.B.B02.example02.IEquip;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 护腕
 * @ author  山羊来了
 * @ date 2019/4/29---9:38
 */
public class WristEquip implements IEquip {

    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "圣战护腕";
    }

}