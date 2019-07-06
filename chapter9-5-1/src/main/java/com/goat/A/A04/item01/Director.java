package com.goat.A.A04.item01;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/6---16:10
 */

public class Director {

    public Human createHumanByDirecotr(IBuildHuman bh){
        bh.buildBody();
        bh.buildFoot();
        bh.buildHand();
        bh.buildHead();
        return bh.createHuman();
    }
}
