package com.goat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 64274 on 2018/11/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/27---22:07
 *
 * http://localhost:8999/#/applications
 */

@SpringBootApplication
@EnableEurekaClient
public class AdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }
}
