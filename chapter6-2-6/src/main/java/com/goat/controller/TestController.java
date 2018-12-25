package com.goat.controller;



import com.goat.enums.Events;
import com.goat.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StateMachine<States, Events> stateMachine1;

    //    http://localhost:8626/test/test1
    @RequestMapping("/test1")
    public void test1()   {
        stateMachine1.start();
        stateMachine1.sendEvent(Events.PAY);
        stateMachine1.sendEvent(Events.RECEIVE);
    }

}
