package com.goat.B.B02.item05;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/16---13:59
 */
public class CompetitorDance extends Competitor{

    private Competitor competitor;

    public CompetitorDance(Competitor competitor){
        this.competitor = competitor;
    }

    @Override
    public void sing(){
        dance();
        competitor.sing();
    }

    public void dance(){
        System.out.println("伴舞中。。。。。。。");
    }
}
