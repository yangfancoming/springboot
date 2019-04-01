package com.goat.C.C06.example00;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 烤鸡翅命令
 * @ author  山羊来了
 * @ date 2019/4/1---13:35
 */

public class ChickenCommond extends Commond{

    public ChickenCommond(Barbecue barbecue) {
        super(barbecue);
    }

    @Override
    public void excuteCommond() {
        super.getBarbecue().makeChicken();
    }

}