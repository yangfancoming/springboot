package com.goat.B.B02.example02.equip;

import com.goat.B.B02.example02.IEquip;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 武器
 * @ author  山羊来了
 * @ date 2019/4/29---9:38
 */
public class ArmEquip implements IEquip {

    @Override
    public int caculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "屠龙刀";
    }

}