package com.goat.B.B03.item02;


import org.junit.Test;

/**
 * Created by 64274 on 2018/7/7.
 *
 * @Description: TODO
 * @date 2018/7/7---19:04
 * 代理模式要点：
 * 真实角色
 * 代理角色: 要持有真实角色的引用
 * 二者实现同一个接口
 */
public class App {

    @Test
    public void test(){

        StarLDH starLDH = new StarLDH("刘德华");
//        StarFBB starFBB = new StarFBB("范冰冰");
        Agent agent = new Agent();
        agent.setStar(starLDH);
        agent.dance();
        agent.sing();

    }
}
