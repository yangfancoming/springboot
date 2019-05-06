package com.goat.game.hero;

import com.goat.game.poker.Card;
import com.goat.game.poker.EquipCard;
import com.goat.game.skill.ActiveSkill;
import com.goat.game.skill.PassiveSkill;

import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---22:55
 */
public class HeroState {

    //当前血量
    protected int curHP;
    //是否死亡
    protected boolean isDead;

    //是否为AI
    protected boolean isAI;
    //装备集合
//    protected EquipmentStructure equipment;

    List<Card> playerCards ;// 英雄手牌
    List<EquipCard> equipCards ;// 英雄装备牌 每个英雄最多4张

    //所中的判定牌集合
//    protected List<AbstractCard> checkedCardList;
    //回合中当前打出的牌
//    protected List<AbstractCard> usedCard;
    //攻击距离
    protected int attDistance ;
    //防御距离
    protected int defDistance ;
    //主动技能
    protected List<ActiveSkill> activeSkills;
    //被动技能
    protected List<PassiveSkill> passiveSkills;
    //额外伤害值
    protected int extDamage;
    //是否出过杀
    protected boolean usedSha ;

}
