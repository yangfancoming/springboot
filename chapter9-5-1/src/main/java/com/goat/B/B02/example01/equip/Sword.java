package com.goat.B.B02.example01.equip;

import com.goat.B.B02.example01.base.Equip;
import com.goat.B.B02.example01.base.IRole;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 剑
 * @ author  山羊来了
 * @ date 2019/4/26---15:07
 */
public class Sword extends Equip {

    private float defense = 20;
    private float power = 40;
    private String describe = "剑";

    public Sword(IRole attribute){
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