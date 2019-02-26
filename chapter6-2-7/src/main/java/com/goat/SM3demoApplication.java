package com.goat;


import com.goat.enums.TurnstileEvents;
import com.goat.service.StatemachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SM3demoApplication implements CommandLineRunner {

    @Autowired
    private StatemachineService statemachineService;

    public static void main(String[] args) {
        SpringApplication.run(SM3demoApplication.class, args);
    }

    @Override
    public void run(String... strings)   {

        Map<String, Object> context = new HashMap<>(16);
        context.put("context", "some code");
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);

    }
}
