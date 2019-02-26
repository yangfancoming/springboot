package com.goat.service;


import com.goat.enums.TurnstileEvents;
import com.goat.enums.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * 实际业务环境中，往往是多线程处理不同的业务ID对应的状态，状态机中利用事件的context传递数据，会出现多线程问题，需要利用状态机工程，利用UUID创建不同状态机。
 * 在StatemachineConfigurer类中，修改@EnableStateMachine为@EnableStateMachineFactory，同时添加状态机处理动作封装方法，读者可以根据业务场景定制，本例为一种可行方案
 */
@Service
public class StatemachineService {

    @Autowired
    private StateMachinePersister<TurnstileStates, TurnstileEvents, Integer> stateMachinePersist;
    @Autowired
    private StateMachineFactory<TurnstileStates, TurnstileEvents> stateMachineFactory;

    public void execute(Integer businessId, TurnstileEvents event, Map<String, Object> context) {
        System.out.println(Thread.currentThread().getName()+ "111111111111111111111111111111111");
        // 利用随记ID创建状态机，创建时没有与具体定义状态机绑定
        StateMachine<TurnstileStates, TurnstileEvents> stateMachine = stateMachineFactory.getStateMachine(UUID.randomUUID());
        stateMachine.start();
        try {
            // 在 BizStateMachinePersist 的 restore 过程中，绑定 turnstileStateMachine 状态机相关事件监听
            stateMachinePersist.restore(stateMachine, businessId);
            // 本处写法较为繁琐，实际为注入 Map<String, Object> context 内容到 message 中
            MessageBuilder<TurnstileEvents> messageBuilder = MessageBuilder.withPayload(event).setHeader("BusinessId", businessId);

            if (context != null) {
                context.entrySet().forEach(p -> messageBuilder.setHeader(p.getKey(), p.getValue()));
            }
            Message<TurnstileEvents> message = messageBuilder.build();
            // 发送事件，返回是否执行成功
            boolean success = stateMachine.sendEvent(message);
            if (success) {
                stateMachinePersist.persist(stateMachine, businessId);
            } else {
                System.out.println("状态机处理未执行成功，请处理，ID：" + businessId + "，当前context：" + context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stateMachine.stop();
        }
    }
}
