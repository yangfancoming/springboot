package com.goat;

//import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
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
 * http://localhost:8777/#/applications
 */

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
