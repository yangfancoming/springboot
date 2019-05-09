package com.goat.game.hero;

import com.goat.game.skill.IActiveSkill;
import com.goat.game.skill.IPassiveSkill;
import com.goat.game.skill.impl.BaWang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 项羽
 * @ author  山羊来了
 * @ date 2019/5/6---21:40
 */
public class XY extends Hero {

    protected final String name = "项羽" ;
    protected final Boolean sex = false;

    protected Integer curHP = 4;
    protected Integer maxHP = 4;
    protected Boolean isDead = false;

    //主动技能
    protected List<IActiveSkill> activeSkills;
    //被动技能
    protected List<IPassiveSkill> passiveSkills = new ArrayList<>();

    public XY() {
        this.activeSkills = null;
        this.passiveSkills.add(new BaWang()); //
    }
}
