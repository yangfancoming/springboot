package com.goat.C.C01.example01.hero;

import com.goat.C.C01.example01.skill.SkillBehavior;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 英雄抽象类
 * @date 2018/11/5---10:09
 */
public abstract class Hero {

    public SkillBehavior mBehavior;

    public Hero(){
        System.out.print("英雄出生 ");
    }
    public void performSkill(){
        if(mBehavior != null){
            mBehavior.useSkill();
        }
    }
    public void setSkillBehavior(SkillBehavior behavior){
        mBehavior = behavior;
    }
}
