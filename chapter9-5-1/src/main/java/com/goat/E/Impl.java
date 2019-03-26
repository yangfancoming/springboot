package com.goat.E;

/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---18:02
 */
public class Impl implements Callback {

    @Override
    public void call() {
        System.out.println("my.................");
    }

    @Override
    public void call2(String para) {
        System.out.println("my2................." + para);
    }
}
