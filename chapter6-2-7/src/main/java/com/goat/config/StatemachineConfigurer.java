package com.goat.config;


import com.goat.dao.BizStateMachinePersist;
import com.goat.enums.TurnstileEvents;
import com.goat.enums.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import java.util.EnumSet;

/**
 * 状态机配置，其中turnstileUnlock()和customerPassAndLock()即为当前状态变更后的扩展业务操作，可以根据实际业务场景进行修改
 */
@Configuration
@EnableStateMachineFactory
public class StatemachineConfigurer extends EnumStateMachineConfigurerAdapter<TurnstileStates, TurnstileEvents> {

    @Autowired
    private BizStateMachinePersist bizStateMachinePersist;

    // 在 StatemachineConfigurer 中发布
    @Bean
    public StateMachinePersister<TurnstileStates, TurnstileEvents, Integer> stateMachinePersist() {
        return new DefaultStateMachinePersister<>(bizStateMachinePersist);
    }

    @Override
    public void configure(StateMachineStateConfigurer<TurnstileStates, TurnstileEvents> states) throws Exception {
        states
                .withStates()
                .initial(TurnstileStates.Locked)  // 初识状态：Locked
                .states(EnumSet.allOf(TurnstileStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<TurnstileStates, TurnstileEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(TurnstileStates.Unlocked).target(TurnstileStates.Locked)
                .event(TurnstileEvents.COIN).action(customerPassAndLock())
                .and()
                .withExternal()
                .source(TurnstileStates.Locked).target(TurnstileStates.Unlocked)
                .event(TurnstileEvents.PUSH).action(turnstileUnlock());
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<TurnstileStates, TurnstileEvents> config) throws Exception {
        config.withConfiguration()
                .machineId("turnstileStateMachine");
    }

    public Action<TurnstileStates, TurnstileEvents> turnstileUnlock() {
        return context -> System.out.println("解锁旋转门，以便游客能够通过，当前状态机上下文：" + context);
    }

    public Action<TurnstileStates, TurnstileEvents> customerPassAndLock() {
        return context -> System.out.println("当游客通过，锁定旋转门，当前状态机上下文：" + context);
    }

}
