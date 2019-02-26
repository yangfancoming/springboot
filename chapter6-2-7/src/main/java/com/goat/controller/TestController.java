package com.goat.controller;


import com.goat.enums.TurnstileEvents;
import com.goat.service.StatemachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StatemachineService statemachineService;


    //    http://localhost:8627/test/test0
    @RequestMapping("/test0")
    public void test0()   {
        Map<String, Object> context = new HashMap<>(16);
        context.put("context", "some code");
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);
    }

}


