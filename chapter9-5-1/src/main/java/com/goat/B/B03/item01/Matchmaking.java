package com.goat.B.B03.item01;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description:  代理角色 持有 被真实角色的引用
 * @date 2018/7/20---14:51
 */
public class Matchmaking implements Marry {

    private Marry marry;

    public Matchmaking(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void marry() {
        System.out.println("前置增强。。。");
        marry.marry();
        System.out.println("后置增强。。。");
    }
}
