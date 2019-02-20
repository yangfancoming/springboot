package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventsApplication {

    /**
        事件驱动模型开发： 监听容器发布的事件  ApplicationListener
    */
	public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EventsApplication.class, args);
        run.publishEvent(new ApplicationEvent("我发布的事件"){});
    }

}
