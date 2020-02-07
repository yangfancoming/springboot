package com.goat.B.B02.example01.equip;

import com.goat.B.B02.example01.base.Equip;
import com.goat.B.B02.example01.base.IRole;

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

    public Shoe(IRole attribute){
        super.role = attribute;
    }

    @Override
    public float getDefense() {
        return super.role.getDefense() + defense;
    }

    @Override
    public float getPower() {
        return super.role.getPower() + power;
    }

    @Override
    public String getDescribe() {
        return super.role.getDescribe() + "," + describe;
    }
}