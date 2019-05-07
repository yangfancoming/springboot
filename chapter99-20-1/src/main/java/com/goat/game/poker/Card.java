package com.goat.game.poker;

import com.goat.game.constant.Suit;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---15:16
 */
public  class Card {

    private String name; // 名称 ：画地为牢

    private String face; // 面值 ：A
    private Suit suit; // 花色：黑桃

    private Boolean AP; // Active Or Passive ： 1-主动牌 2-被动牌
    private String  type; // 类型：装备牌  锦囊牌  基本牌

    public Card(String face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAP() {
        return AP;
    }

    public void setAP(Boolean AP) {
        this.AP = AP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "{" + suit + face + '}';
    }
}
