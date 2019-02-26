package com.goat;

import com.goat.enums.Events;
import com.goat.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication

public class SMdemoApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SMdemoApplication.class, args);
	}

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}
