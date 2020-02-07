package com.goat.B.B02.item05;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: 鼓掌
 * @ author  山羊来了
 * @ date 2019/7/16---13:58
 */
public class CompetitorApplause extends Competitor{

    private Competitor competitor;

    public CompetitorApplause(Competitor competitor){
        this.competitor = competitor;
    }

    @Override
    public void sing(){
        applause();
        competitor.sing();
    }

    public void applause(){
        System.out.println("鼓掌中。。。。。。。。");
    }
}
