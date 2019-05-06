package com.goat.game.hero;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 英雄 抽象类
 * @ author  山羊来了
 * @ date 2019/5/6---20:47
 */
public abstract class Hero {

    protected  HeroInfo heroInfo;
    protected HeroState heroState;

    public abstract void skill();

    public HeroInfo getHeroInfo() {
        return heroInfo;
    }

    public void setHeroInfo(HeroInfo heroInfo) {
        this.heroInfo = heroInfo;
    }

    public HeroState getHeroState() {
        return heroState;
    }

    public void setHeroState(HeroState heroState) {
        this.heroState = heroState;
    }
}
