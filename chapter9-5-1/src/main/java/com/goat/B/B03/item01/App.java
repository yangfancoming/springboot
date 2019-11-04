package com.goat.B.B03.item01;

import org.junit.Test;

/**
 * Created by 64274 on 2018/7/7.
 * @date 2018/7/7---19:04
 * 静态代理模式要点：
 * 1.  代理角色要持有真实角色的引用
 * 2.  二者实现同一个接口
 */
public class App {
    @Test
    public void test(){
        Matchmaking matchmaking1 = new Matchmaking(new Shihanzhi());
        Matchmaking matchmaking2 = new Matchmaking(new Yangfan());
        matchmaking1.marry();
        matchmaking2.marry();
    }
}
