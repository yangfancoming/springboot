package com.goat.A.A04.item01;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/6---16:10
 */
public class App {

    public static void main(String[] args){

        Director director = new Director();

        IBuildHuman smartManBuilder = new SmartManBuilder();
        Human human = director.createHumanByDirecotr(smartManBuilder);
        System.out.println(human.getHead());
        System.out.println(human.getBody());
        System.out.println(human.getHand());
        System.out.println(human.getFoot());
    }


}
