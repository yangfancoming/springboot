package com.goat.monitor;

import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 动作监听类
 * 本例中使用id进行状态机绑定，根据文档定义，可以使用name和id两种属性绑定需要监听的状态机实例。如果不定义任何name或者id，默认监听名称为stateMachine的状态机
 */
@WithStateMachine(id = "turnstileStateMachine")
public class StatemachineMonitor {

    @OnTransition
    public void anyTransition() {
        System.out.println("进入monitor监视器--- OnTransition --- init");
    }

    @OnTransition(target = "Unlocked")
    public void toState1() {
        System.out.println("进入monitor监视器--- OnTransition --- toState1");
    }

    @OnTransition(target = "Locked")
    public void toState2() {
        System.out.println("进入monitor监视器--- OnTransition --- toState2");
    }

    @OnStateChanged(source = "Unlocked")
    public void fromState1() {
        System.out.println("进入monitor监视器--- OnTransition --- fromState1");
    }
}
