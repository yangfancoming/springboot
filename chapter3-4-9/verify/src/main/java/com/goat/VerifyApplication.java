package com.goat;

import com.goat.service.VerifyLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
     * @Description:  校检 license.lic 证书 文件
     * @author: 杨帆
     * @Date:   2018/12/14
*/
@SpringBootApplication
public class VerifyApplication implements CommandLineRunner {
    @Autowired
    VerifyLicenseService verifyLicenseService;

    public static void main(String[] args) {
        SpringApplication.run(VerifyApplication.class);
    }

    @Override
    public void run(String... strings)  {
        verifyLicenseService.doVerifyLicense();
    }
}
