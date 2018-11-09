package com.goat.B.B03.example02;

/**
 * Created by 64274 on 2018/7/25.
 *
 * @author 山羊来了
 * @Description:  刘德华 被代理对象
 * @date 2018/7/25---12:06
 */
public class StarLDH implements Perform {

    private String starName;

    public StarLDH(String starName) {
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
