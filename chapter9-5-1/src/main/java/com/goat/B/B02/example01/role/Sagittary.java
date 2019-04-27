package com.goat.B.B02.example01.role;

import com.goat.B.B02.example01.base.IAttribute;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 弓箭手
 * @ author  山羊来了
 * @ date 2019/4/26---15:05
 */
public class Sagittary implements IAttribute {
    //防御力
    private float defense = 10f;
    //攻击力
    private float power = 30f;
    //描述
    private String describe = "弓箭手";

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