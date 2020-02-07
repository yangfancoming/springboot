package com.goat.B.B02.example01.equip;

import com.goat.B.B02.example01.base.Equip;
import com.goat.B.B02.example01.base.IRole;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 法杖
 * @ author  山羊来了
 * @ date 2019/4/26---15:07
 */
public class Wand extends Equip {

    private float defense = 2;
    private float power = 90;
    private String describe = "法杖";

    public Wand(IRole attribute){
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