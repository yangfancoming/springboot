package com.goat.game.hero;

import com.goat.game.poker.Card;

import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 英雄 抽象类
 * @ author  山羊来了
 * @ date 2019/5/6---20:47
 */
public abstract class Hero {

//    //人物名称
    protected String name ;
//    //血量上限
    protected Integer maxHP;
//    //人物性别 真-男；假-女
    protected Boolean sex;
    protected Integer curHP  ;
    protected Boolean isDead  ;

    protected List<Card> playerCards;
//    protected  HeroInfo heroInfo = new HeroInfo();
//    protected HeroState heroState = new HeroState();


    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getCurHP() {
        return curHP;
    }

    public void setCurHP(Integer curHP) {
        this.curHP = curHP;
    }

    public Boolean getDead() {
        return isDead;
    }

    public void setDead(Boolean dead) {
        isDead = dead;
    }
}
