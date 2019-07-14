package com.goat.B.B01.item02;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/14---11:49
 */
/**
 * 类适配器使用demo
 */
public class PowerAdapter extends AC220 implements DC5 {

    @Override
    public int output5V() {
        int output = output220V();
        return (output / 44);
    }
}
