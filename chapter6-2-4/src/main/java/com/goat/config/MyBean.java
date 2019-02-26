package com.goat.config;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/26---20:26
 */

@WithStateMachine
public class MyBean {

    @OnTransition(target = "STATE1")
    void toState1() {
        System.out.println("MyBean.............toState1");
    }

    @OnTransition(target = "STATE2")
    void toState2() {
        System.out.println("MyBean.............toState2");
    }
}
