package com.goat.B.B02.example01.role;

import com.goat.B.B02.example01.base.IRole;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 法师
 * @ author  山羊来了
 * @ date 2019/4/26---15:05
 */
public class Mage implements IRole {
    //防御力
    private float defense = 5f;
    //攻击力
    private float power = 40f;
    //描述
    private String describe = "法师";

    @Override
    public String getDescribe() {
        return describe;
    }

    @Override
    public float getPower() {
        return power;
    }

    @Override
    public float getDefense() {
        return defense;
    }
}