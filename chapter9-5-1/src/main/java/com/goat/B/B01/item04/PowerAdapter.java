package com.goat.B.B01.item04;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/14---11:58
 */

import com.goat.B.B01.item02.AC220;

/**
 * 这里抽象类其实就写了空方法，等着子类去实现需要的方法。
 */
public abstract class PowerAdapter implements DCOutput{

    protected AC220 mAC220;

    public PowerAdapter(AC220 ac220){
        this.mAC220 = ac220;
    }

    @Override
    public int output5V() {
        return mAC220.output220V();
    }

    @Override
    public int output9V() {
        return mAC220.output220V();
    }

    @Override
    public int output12V() {
        return mAC220.output220V();
    }

    @Override
    public int output24V() {
        return mAC220.output220V();
    }
}
