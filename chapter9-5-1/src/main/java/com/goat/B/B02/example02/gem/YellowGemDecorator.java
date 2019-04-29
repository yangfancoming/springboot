package com.goat.B.B02.example02.gem;

import com.goat.B.B02.example02.IEquip;
import com.goat.B.B02.example02.IEquipDecorator;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 每个装饰品维护一个装备
 * @ author  山羊来了
 * @ date 2019/4/29---9:40
 */
public class YellowGemDecorator implements IEquipDecorator {

    private IEquip equip;

    public YellowGemDecorator(IEquip equip){
        this.equip = equip;
    }

    @Override
    public int caculateAttack(){
        return 10 + equip.caculateAttack();
    }

    @Override
    public String description(){
        return equip.description() + "+ 黄宝石";
    }

}