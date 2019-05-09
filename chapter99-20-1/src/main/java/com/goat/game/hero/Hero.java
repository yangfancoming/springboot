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
//    protected String name ;
//    //血量上限
//    protected Integer maxHP;
//    //人物性别 真-男；假-女
//    protected Boolean sex;

    protected List<Card> playerCards;
//    protected  HeroInfo heroInfo = new HeroInfo();
//    protected HeroState heroState = new HeroState();


    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }
}
