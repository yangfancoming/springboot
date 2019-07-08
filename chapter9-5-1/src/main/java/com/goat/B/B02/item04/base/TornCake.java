package com.goat.B.B02.item04.base;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: 手抓饼
 * @ author  山羊来了
 * @ date 2019/5/13---9:03
 */
public class TornCake implements Pancake  {

    @Override
    public String getDesc() {
        return "【手抓饼】";
    }

    @Override
    public double price() {
        return 4;
    }

}