package com.goat.controller;


import com.goat.enums.RegEventEnum;
import com.goat.enums.RegStatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine2;

    //    http://localhost:8625/test/test2
    @RequestMapping("/test2")
    public void test2()   {
        stateMachine2.start();
        stateMachine2.sendEvent(RegEventEnum.CONNECT);
        stateMachine2.sendEvent(RegEventEnum.REGISTER);
        stateMachine2.sendEvent(RegEventEnum.REGISTER_SUCCESS);
        stateMachine2.sendEvent(RegEventEnum.UN_REGISTER);
        stateMachine2.sendEvent(RegEventEnum.CONNECT);

    }
}
