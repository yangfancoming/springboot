package com.goat.B.B02.example01.equip;

import com.goat.B.B02.example01.base.Equip;
import com.goat.B.B02.example01.base.IAttribute;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 鞋子
 * @ author  山羊来了
 * @ date 2019/4/26---15:06
 */
public class Shoe extends Equip {

    private float defense = 70;
    private float power = 10;
    private String describe = "鞋子";

    public Shoe(IAttribute attribute){
        super.attribute = attribute;
    }

    @Override
    public float getDefense() {
        return super.attribute.getDefense() + defense;
    }

    @Override
    public float getPower() {
        return super.attribute.getPower() + power;
    }

    @Override
    public String getDescribe() {
        return super.attribute.getDescribe() + "," + describe;
    }
}