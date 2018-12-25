package com.goat.config;

import com.goat.enums.Events;
import com.goat.enums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;


@Configuration
@EnableStateMachine// 启用Spring StateMachine状态机功能
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    //初始化当前状态机拥有哪些状态
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)throws Exception {
        states
            .withStates()
                .initial(States.UNPAID) // 定义了初始状态为 UNPAID
                .states(EnumSet.allOf(States.class)); // 定义了定义状态机中存在的所有状态。
    }

    // 初始化当前状态机有哪些状态迁移事件，其中命名中我们很容易理解每一个迁移动作
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)throws Exception {
        transitions
            .withExternal()
                .source(States.UNPAID) // source 来源状态
                .target(States.WAITING_FOR_RECEIVE)//   target 目标状态
                .event(Events.PAY)// 触发事件event
                .and()
            .withExternal()
                .source(States.WAITING_FOR_RECEIVE)
                .target(States.DONE)
                .event(Events.RECEIVE);
    }

}
