package com.goat.C.C06.example00;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 命令抽象父类
 * @ author  山羊来了
 * @ date 2019/4/1---13:35
 */

public abstract class Commond {

    private Barbecue barbecue;

    public Commond(Barbecue barbecue) {
        this.barbecue = barbecue;
    }

    public abstract void excuteCommond();

    public Barbecue getBarbecue() {
        return barbecue;
    }

}