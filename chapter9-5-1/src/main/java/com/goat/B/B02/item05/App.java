package com.goat.B.B02.item05;

import org.junit.Test;

/**
 * Created by 64274 on 2019/7/16.
 * @ Description:  三层嵌套的 test3 和 test4 方法 表明 装饰模式是有顺序的，装饰顺序的不同，会导致执行结果的不同
 * @ author  山羊来了
 * @ date 2019/7/16---13:59
 */
public class App {

    Competitor competitor = new Competitor();

    @Test
    public void test0() {
        competitor.sing();
    }

    // 一层嵌套
    @Test
    public void test1() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor); // 伴奏装饰
        competitorMusic.sing();
    }

    // 二层嵌套
    @Test
    public void test2() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor); // 伴奏装饰
        CompetitorDance competitorDance = new CompetitorDance(competitorMusic);// 伴舞装饰
        competitorDance.sing();
    }

    /**
     * 三层嵌套
     * 鼓掌中。。。。。。。。
     * 伴舞中。。。。。。。
     * 伴奏中。。。。。
     */
    @Test
    public void test3() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor);// 伴奏装饰
        CompetitorDance competitorDance = new CompetitorDance(competitorMusic);// 伴舞装饰
        CompetitorApplause competitorApplause = new CompetitorApplause(competitorDance);// 鼓掌装饰
        competitorApplause.sing();
    }

    /**
     * 三层嵌套
     * 伴舞中。。。。。。。
     * 鼓掌中。。。。。。。。
     * 伴奏中。。。。。
    */
    @Test
    public void test4() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor);// 伴奏装饰
        CompetitorApplause competitorDance = new CompetitorApplause(competitorMusic);// 鼓掌装饰
        CompetitorDance competitorApplause = new CompetitorDance(competitorDance);// 伴舞装饰
        competitorApplause.sing();
    }

    // 实战业务  测试
    @Test
    public void testWithBusiness(){
        Competitor competitor = new Competitor();
        int a = 30;
        //做业务判断
        if( a < 10 ){ competitor = new CompetitorDance(competitor); }
        if( a == 10 ){ competitor = new CompetitorMusic(competitor); }
        if( a > 20) { competitor = new CompetitorApplause(competitor); }
        competitor.sing();
    }

}
