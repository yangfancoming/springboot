package com.goat.B.B03.example02;

/**
 * Created by 64274 on 2018/7/25.
 *
 * @author 山羊来了
 * @Description: 范冰冰 被代理对象
 * @date 2018/7/25---12:06
 */
public class StarFBB implements Perform {

    private String starName;

    public StarFBB(String starName) {
        this.starName = starName;
    }

    @Override
    public void sing() {
        System.out.println(starName + "在唱歌。。。。。。。。。");
    }

    @Override
    public void dance() {
        System.out.println(starName + "在跳舞。。。。。。。。。");
    }
}
