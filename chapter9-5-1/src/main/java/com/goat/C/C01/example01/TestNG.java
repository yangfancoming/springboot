package com.goat.C.C01.example01;


import com.goat.C.C01.example01.hero.DiRenJie;
import com.goat.C.C01.example01.hero.Hero;
import com.goat.C.C01.example01.hero.LuBan;
import com.goat.C.C01.example01.hero.XiangYu;
import com.goat.C.C01.example01.skill.GunSkill;
import com.goat.C.C01.example01.skill.SkillBehavior;
import org.testng.annotations.Test;


public class TestNG {

    @Test
    public void test1() {
        Hero mDi = new DiRenJie();
        mDi.performSkill();
        Hero mXiang = new XiangYu();
        mXiang.performSkill();
        Hero mLu = new LuBan();
        mLu.performSkill();
    }

    // 英雄技能 可以互换
    @Test
    public void test2() {
        Hero mDi = new DiRenJie();
        SkillBehavior gunSkill = new GunSkill();
        mDi.setSkillBehavior(gunSkill);
        mDi.performSkill();
    }

}
