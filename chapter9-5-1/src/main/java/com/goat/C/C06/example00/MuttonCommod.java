package com.goat.C.C06.example00;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 烤羊腿命令
 * @ author  山羊来了
 * @ date 2019/4/1---13:36
 */

public class MuttonCommod extends Commond{

    public MuttonCommod(Barbecue barbecue) {
        super(barbecue);
    }

    @Override
    public void excuteCommond() {
        super.getBarbecue().makeMutton();
    }

}