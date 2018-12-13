package com.goat;

import com.goat.service.VerifyLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by futureX on 2018/6/7.
 */
@SpringBootApplication
public class VerifyApplication implements CommandLineRunner {
    @Autowired
    VerifyLicenseService verifyLicenseService;

    public static void main(String[] args) {
        SpringApplication.run(VerifyApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        verifyLicenseService.doVerifyLicense();
    }
}
