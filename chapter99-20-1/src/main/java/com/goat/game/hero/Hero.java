package com.goat.game.hero;

import com.goat.game.poker.Pocker;

import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 英雄 抽象类
 * @ author  山羊来了
 * @ date 2019/5/6---20:47
 */
public abstract class Hero {

    String name; // 名称

    Boolean sex; //性别 1=男 0=女

    Integer hp; // 血值

    List<Pocker> playerPockers ;// 英雄手牌

    public abstract void skill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public List<Pocker> getPlayerPockers() {
        return playerPockers;
    }

    public void setPlayerPockers(List<Pocker> playerPockers) {
        this.playerPockers = playerPockers;
    }
}
