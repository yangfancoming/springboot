package com.goat.game.hero;

import com.goat.game.poker.Card;
import com.goat.game.poker.EquipCard;
import com.goat.game.skill.IActiveSkill;
import com.goat.game.skill.IPassiveSkill;

import java.util.LinkedList;
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

    List<Card> playerCards = new LinkedList<>();// 英雄手牌
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
    protected List<IActiveSkill> activeSkills;
    //被动技能
    protected List<IPassiveSkill> passiveSkills;
    //额外伤害值
    protected int extDamage;
    //是否出过杀
    protected boolean usedSha ;


    public int getCurHP() {
        return curHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<EquipCard> getEquipCards() {
        return equipCards;
    }

    public void setEquipCards(List<EquipCard> equipCards) {
        this.equipCards = equipCards;
    }

    public int getAttDistance() {
        return attDistance;
    }

    public void setAttDistance(int attDistance) {
        this.attDistance = attDistance;
    }

    public int getDefDistance() {
        return defDistance;
    }

    public void setDefDistance(int defDistance) {
        this.defDistance = defDistance;
    }

    public List<IActiveSkill> getActiveSkills() {
        return activeSkills;
    }

    public void setActiveSkills(List<IActiveSkill> activeSkills) {
        this.activeSkills = activeSkills;
    }

    public List<IPassiveSkill> getPassiveSkills() {
        return passiveSkills;
    }

    public void setPassiveSkills(List<IPassiveSkill> passiveSkills) {
        this.passiveSkills = passiveSkills;
    }

    public int getExtDamage() {
        return extDamage;
    }

    public void setExtDamage(int extDamage) {
        this.extDamage = extDamage;
    }

    public boolean isUsedSha() {
        return usedSha;
    }

    public void setUsedSha(boolean usedSha) {
        this.usedSha = usedSha;
    }
}
