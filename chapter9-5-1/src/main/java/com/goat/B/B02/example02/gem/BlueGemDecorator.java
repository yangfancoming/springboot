package com.goat.B.B02.example02.gem;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/29---9:40
 */

import com.goat.B.B02.example02.IEquip;
import com.goat.B.B02.example02.IEquipDecorator;

/**
 * 蓝宝石装饰品
 * 每颗攻击力+5
 * @author zhy
 *
 */
public class BlueGemDecorator implements IEquipDecorator {
    /**
     * 每个装饰品维护一个装备
     */
    private IEquip equip;

    public BlueGemDecorator(IEquip equip) {
        this.equip = equip;
    }

    @Override
    public int caculateAttack() {
        return 5 + equip.caculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "+ 蓝宝石";
    }

}