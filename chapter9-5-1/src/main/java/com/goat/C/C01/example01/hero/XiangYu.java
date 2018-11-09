package com.goat.C.C01.example01.hero;

import com.goat.C.C01.example01.skill.KnifeSkill;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 项羽
 * @date 2018/11/5---10:12
 */
public class XiangYu extends Hero {

    public XiangYu(){
        super();
        System.out.println("项羽：我命由我... ");
        mBehavior = new KnifeSkill();
    }
}
