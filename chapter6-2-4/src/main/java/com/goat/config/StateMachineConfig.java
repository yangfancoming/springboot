package com.goat.config;

import com.goat.enums.Events;
import com.goat.enums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/26---18:07
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    /*
     configure用来初始化当前状态机拥有哪些状态。
     * */
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.STATE1)   //定义了初始状态为 STATE1
                .states(EnumSet.allOf(States.class));  //指定States中的所有状态作为该状态机的状态定义。
    }


    /*
    configure用来初始化当前状态机有哪些状态迁移动作
    从其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
    * */
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.STATE1).target(States.STATE2)
                .event(Events.EVENT1)
                .and()
                .withExternal()
                .source(States.STATE2).target(States.STATE1)
                .event(Events.EVENT2);
    }

}
