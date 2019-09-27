package com.goat.B.B02.item05;

import org.junit.Test;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/16---13:59
 */
public class App {

    Competitor competitor = new Competitor();



    @Test
    public void test1() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor);
        competitorMusic.sing();
    }

    @Test
    public void test2() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor);
        CompetitorDance competitorDance = new CompetitorDance(competitorMusic);
        competitorDance.sing();
    }

    @Test
    public void test3() {
        CompetitorMusic competitorMusic = new CompetitorMusic(competitor);
        CompetitorDance competitorDance = new CompetitorDance(competitorMusic);
        CompetitorApplause competitorApplause = new CompetitorApplause(competitorDance);
        competitorApplause.sing();
    }

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
