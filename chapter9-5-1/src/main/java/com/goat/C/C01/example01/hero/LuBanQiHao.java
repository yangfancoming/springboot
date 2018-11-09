package com.goat.C.C01.example01.hero;

import com.goat.C.C01.example01.skill.GunSkill;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 鲁班七号
 * @date 2018/11/5---10:12
 */
public class LuBanQiHao extends Hero {

    public LuBanQiHao() {
        super();
        System.out.println("鲁班七号：魔法大师，智障250，@￥%*&￥#... ");
        mBehavior = new GunSkill();
    }
}
