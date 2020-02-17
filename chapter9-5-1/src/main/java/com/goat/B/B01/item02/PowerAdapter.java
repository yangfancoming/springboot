package com.goat.B.B01.item02;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description: 类适配器使用demo  继承方式
 * @ author  山羊来了
 * @ date 2019/7/14---11:49
 */
public class PowerAdapter extends AC220 implements DC5 {

    @Override
    public int output5V() {
        int output = output220V();
        return (output / 44);
    }
}
