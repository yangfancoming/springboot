package com.goat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Description:
 * @author: 杨帆
 * @Date:   2018/12/14
 */
@SpringBootApplication
public class LicenseApplication {
    @Autowired
//    CreateLicenseService createLicenseService;

    public static void main(String[] args) {
        SpringApplication.run(LicenseApplication.class);
    }

//    @Override
//    public void run(String... strings) {
//        createLicenseService.doCreateLicense();
//    }
}
