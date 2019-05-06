package com.goat.game.hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---22:57
 */
public class HeroInfo {

    //人物名称
    protected String name ;
    //血量上限
    protected Integer maxHP;
    //人物性别 真-男；假-女
    protected Boolean sex;

    //主动技能的类名
    protected List<String> skillName = new ArrayList<>();
    // 被动技类名
    protected List<String> lockingSkill = new ArrayList<>();
}
