package com.goat.C.C05.item03;

/**
 * Created by 64274 on 2019/9/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/9/22---21:00
 */
public class App {

    public static void main(String[] args) {
        String input = "A";
        ResponsibilityChain chain= new ResponsibilityChain();
        chain.add(new AResponsibility())
                .add(new BResponsibility())
                .add(new CResponsibility());
        chain.doSomething(input, chain);
    }


}
