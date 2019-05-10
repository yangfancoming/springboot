package com.goat.game.poker;

import com.goat.game.constant.Name;
import com.goat.game.constant.Suit;
import com.goat.game.constant.Type;

/**
 * Created by 64274 on 2019/5/6.
 * @ Description: 卡牌总类
 * @ author  山羊来了
 * @ date 2019/5/6---15:16
 */
public  class Card {

    private Name name; // 名称 ：画地为牢

    private String face; // 面值 ：A
    private Suit suit; // 花色：黑桃

    private Boolean AP; // Active Or Passive ： 1-主动牌 2-被动牌
    private Type type; // 类型：装备牌  锦囊牌  基本牌

    public Card( Suit suit,String face) {
        this.suit = suit;
        this.face = face;
    }

    public Card( Suit suit,String face,Name name) {
        this.suit = suit;
        this.face = face;
        this.name = name;
    }

    public Card(Suit suit, String face, Name name, Boolean AP, Type type) {
        this.name = name;
        this.face = face;
        this.suit = suit;
        this.AP = AP;
        this.type = type;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Boolean getAP() {
        return AP;
    }

    public void setAP(Boolean AP) {
        this.AP = AP;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
        return "Card{" + "name=" + name + ", face='" + face + '\'' + ", suit=" + suit + ", AP=" + AP + ", type=" + type + '}' + '\n';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
