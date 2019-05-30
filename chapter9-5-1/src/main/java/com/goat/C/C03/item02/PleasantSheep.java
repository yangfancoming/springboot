package com.goat.C.C03.item02;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/30---14:11
 */
public class PleasantSheep implements Observer{

    @Override
    public String getName() {
        return "喜羊羊";
    }

    /*** 具体业务逻辑*/
    @Override
    public void update(String msg) {
        System.out.println("喜羊羊收到通知：" + msg);
    }
}