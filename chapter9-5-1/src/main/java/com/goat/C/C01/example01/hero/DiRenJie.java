package com.goat.C.C01.example01.hero;

import com.goat.C.C01.example01.skill.ArrowSkill;

/**
 * Created by 64274 on 2018/11/5.
 *
 * @author 山羊来了
 * @Description: 狄仁杰
 * @date 2018/11/5---10:11
 */
public class DiRenJie extends Hero {

    public DiRenJie(){
        super();
        System.out.println("狄仁杰：代表法律制裁你...");
        mBehavior = new ArrowSkill();
    }
}

