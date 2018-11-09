package com.goat.B.B03.example01;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: 真实角色 (被代理对象)
 * @date 2018/7/20---14:50
 */
public class Tom implements Marry {

    @Override
    public void marry() {
        System.out.println("我是汤姆，我终于结婚啦！");
    }
}
