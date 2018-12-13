package com.goat.service;


import com.goat.client.VerifyLicense;
import com.goat.config.LicenseCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * 验证license
 */
@Service
@EnableConfigurationProperties({LicenseCommon.class})
public class VerifyLicenseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyLicenseService.class);

    @Autowired
    LicenseCommon licenseCommon;

    /**
     * 验证证书
     */
    public void doVerifyLicense() {
        this.checkProperty();
        LOGGER.info("\nlicense配置信息如下：\n" + licenseCommon.toString());
        boolean success = new VerifyLicense().verify(licenseCommon);
        LOGGER.info("***************************************");
        LOGGER.info("Verify license result is :" + success);
        LOGGER.info("***************************************");
    }

    /**
     * 校验必要的属性
     */
    private void checkProperty() {
        final String alias = licenseCommon.getAlias();
        if (isEmpty(alias)) {
            throw new IllegalArgumentException("[license.verify.alias]不能为空");
        }
        final String storepass = licenseCommon.getStorepass();
        if (isEmpty(storepass)) {
            throw new IllegalArgumentException("[license.verify.storepass]不能为空");
        }
        final String subject = licenseCommon.getSubject();
        if (isEmpty(subject)) {
            throw new IllegalArgumentException("[license.verify.subject]不能为空");
        }
        final String licensePath = licenseCommon.getLicensePath();
        if (isEmpty(licensePath)) {
            throw new IllegalArgumentException("[license.verify.license-path]不能为空");
        }
        final String resource = licenseCommon.getResource();
        if (isEmpty(resource)) {
            throw new IllegalArgumentException("[license.verify.resource]不能为空");
        }
    }
}
