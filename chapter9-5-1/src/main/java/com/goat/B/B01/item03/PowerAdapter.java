package com.goat.B.B01.item03;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description: 类适配器使用demo  组合注入方式
 * @ author  山羊来了
 * @ date 2019/7/14---11:49
 */


import com.goat.B.B01.item02.AC220;
import com.goat.B.B01.item02.DC5;

public class PowerAdapter implements DC5 {

    private AC220 mAC220;

    public PowerAdapter(AC220 ac220){
        this.mAC220 = ac220;
    }

    @Override
    public int output5V() {
        int output = mAC220.output220V() / 44;
        return output;
    }

}
