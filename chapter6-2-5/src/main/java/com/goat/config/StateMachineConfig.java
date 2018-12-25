package com.goat.config;

import com.goat.enums.RegEventEnum;
import com.goat.enums.RegStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/12/25
*/
@Configuration
@EnableStateMachine
//@EnableStateMachine(name = "ddd")
//@EnableStateMachineFactory(name = "recruitStateMachineFactory")
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<RegStatusEnum, RegEventEnum> {

    /**
     * 初始化状态机状态
     */
    @Override
    public void configure(StateMachineStateConfigurer<RegStatusEnum, RegEventEnum> states) throws Exception {
        states.withStates()
        // 定义初始状态
        .initial(RegStatusEnum.UNCONNECTED)
        // 定义状态机状态
        .states(EnumSet.allOf(RegStatusEnum.class));
    }
    /**
     * 初始化状态迁移事件
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<RegStatusEnum, RegEventEnum> transitions) throws Exception {
        transitions
            // 1.连接事件
            // 未连接 -> 已连接
            .withExternal()
                .source(RegStatusEnum.UNCONNECTED)
                .target(RegStatusEnum.CONNECTED)
                .event(RegEventEnum.CONNECT)
            .and()                     
            
            // 2.注册事件   
            // 已连接 -> 注册中
            .withExternal()
                .source(RegStatusEnum.CONNECTED)
                .target(RegStatusEnum.REGISTERING)
                .event(RegEventEnum.REGISTER)
            .and()
            
            // 3.注册成功事件   
            // 注册中 -> 已注册
            .withExternal()
                .source(RegStatusEnum.REGISTERING)
                .target(RegStatusEnum.REGISTERED)
                .event(RegEventEnum.REGISTER_SUCCESS)
            .and()
            
            // 5.注销事件
            // 已连接 -> 未连接
            .withExternal()
                .source(RegStatusEnum.CONNECTED)
                .target(RegStatusEnum.UNCONNECTED)
                .event(RegEventEnum.UN_REGISTER)
            .and()
            // 注册中 -> 未连接
            .withExternal()
                .source(RegStatusEnum.REGISTERING)
                .target(RegStatusEnum.UNCONNECTED)
                .event(RegEventEnum.UN_REGISTER)
            .and()
            // 已注册 -> 未连接
            .withExternal()
                .source(RegStatusEnum.REGISTERED)
                .target(RegStatusEnum.UNCONNECTED)
                .event(RegEventEnum.UN_REGISTER)
            ;
    }


    /*
        持久化状态机 StateMachinePersister
        持久性功能允许用户将状态机本身的状态保存到外部存储库中，然后根据序列化状态重置状态机。例如，如果您有一个数据库表保持订单，如果需要为每个更改构建一个新实例，那么通过状态机更新订单状态会太昂贵。持久性功能允许您重置状态机状态，而无需实例化新的状态机实例
        可以使用状态机拦截器而不是在状态机内的状态改变期间完成将序列化状态保存到外部存储器的尝试。如果此拦截器回调失败，则状态更改尝试将暂停，而不是结束到不一致状态，然后用户可以手动处理此错误
     */

}