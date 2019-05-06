package com.goat.game.hero;

import com.goat.game.poker.Pocker;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---20:47
 */
public abstract class Hero {

    Integer hp;

    List<Pocker> playerPockers = new LinkedList();

    public abstract void skill();

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
