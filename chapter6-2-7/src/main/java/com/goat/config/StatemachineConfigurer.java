package com.goat.config;


import com.goat.dao.BizStateMachinePersist;
import com.goat.enums.TurnstileEvents;
import com.goat.enums.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.annotation.WithStateMachine;
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
 * 在 StatemachineConfigurer 类中，修改 @EnableStateMachine 为 @EnableStateMachineFactory ，同时添加状态机处理动作封装方法，读者可以根据业务场景定制，本例为一种可行方案
 * 注解 @EnableStateMachine 用来定义 静态状态机
 * 有些时候，一个状态机不够用，这个时候就要用到了状态机工厂。 即：@EnableStateMachineFactory
 */
@Configuration
@EnableStateMachineFactory
public class StatemachineConfigurer extends EnumStateMachineConfigurerAdapter<TurnstileStates, TurnstileEvents> {

    public static final String MachineId = "turnstileStateMachine";

    @Autowired
    private BizStateMachinePersist bizStateMachinePersist;

    //  持久化配置 实际使用中，可以配合redis等，进行持久化操作
    @Bean
    public StateMachinePersister<TurnstileStates, TurnstileEvents, Integer> stateMachinePersist() {
        return new DefaultStateMachinePersister<>(bizStateMachinePersist);
    }

    @Override // 配置状态
    public void configure(StateMachineStateConfigurer<TurnstileStates, TurnstileEvents> states) throws Exception {
        states
                .withStates()
                .initial(TurnstileStates.Locked)  // 初识状态：Locked
                .states(EnumSet.allOf(TurnstileStates.class));
    }

    @Override // 配置状态转换事件关系
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
//    machineid定义了状态机的Id名称，那么我们在 @WithStateMachine() 注解就可以定义name等于同样的id，即可被该监听器监听状态变迁
    @Override
    public void configure(StateMachineConfigurationConfigurer<TurnstileStates, TurnstileEvents> config) throws Exception {
        config.withConfiguration()
//                .autoStartup(true) // 如果没有设置autoStartup，状态机必须手动start()。
                .machineId(MachineId);
    }

    public Action<TurnstileStates, TurnstileEvents> turnstileUnlock() {
        return context -> System.out.println("解锁旋转门，以便游客能够通过，当前状态机上下文：" + context);
    }

    public Action<TurnstileStates, TurnstileEvents> customerPassAndLock() {
        return context -> System.out.println("当游客通过，锁定旋转门，当前状态机上下文：" + context);
    }

}
