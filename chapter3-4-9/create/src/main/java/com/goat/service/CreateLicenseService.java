package com.goat.service;


import com.goat.client.CreateLicense;
import com.goat.config.LicenseCheck;
import com.goat.config.LicenseCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * 创建License
 *
 * 注意：一定要将第一步生成的myPrivateKeyStore.store密钥库文件拷贝到类路径下
 * 如何获取类路径：在Test.java中可以查看一下
 * String path = Test.class.getResource("/").getPath();
 * System.out.println("path="+path);
 */
@Service
@EnableConfigurationProperties({LicenseCommon.class, LicenseCheck.class})
public class CreateLicenseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateLicenseService.class);

    @Autowired
    LicenseCommon licenseCommon;

    @Autowired
    LicenseCheck licenseCheck;

    public void doCreateLicense() {
        this.checkProperty();
        Boolean success = new CreateLicense().create(licenseCommon, licenseCheck);
        LOGGER.info("***************************************");
        LOGGER.info("License create result is :" + success);
        LOGGER.info("***************************************");
        LOGGER.info("generated lincense path: {}", licenseCommon.getLicensePath());
        LOGGER.info("\nlicense配置信息如下：\n" + licenseCommon.toString() + "\n" + licenseCheck.toString());
        /*
        * license配置信息如下：
        *    LicenseCommon{resource='/privateKey.store', alias='privatekey', storePass='init123', keyPass='init123', subject='license', licensePath='./license.lic'}
        *    LicenseCheck{issuedTime='null', notBefore='null', notAfter='2019-10-1', consumerType='user', consumerAmount=1, info='null', commonName='Unknown', country='Unknown', locality='Unknown', state='Unknown'}
        * */
    }

    /**
     * 校验必要的属性
     */
    private void checkProperty() {
        // 校验必要属性不能为空
        final String alias = licenseCommon.getAlias();
        if (isEmpty(alias)) {
            throw new IllegalArgumentException("[license.create.alias]不能为空");
        }
        final String resource = licenseCommon.getResource();
        if (isEmpty(resource)) {
            throw new IllegalArgumentException("[license.create.resource]不能为空");
        }
        final String storepass = licenseCommon.getStorepass();
        if (isEmpty(storepass)) {
            throw new IllegalArgumentException("[license.create.storepass]不能为空");
        }
        final String licensePath = licenseCommon.getLicensePath();
        if (isEmpty(licensePath)) {
            throw new IllegalArgumentException("[license.create.license-path]不能为空");
        }
        final  String subject = licenseCommon.getSubject();
        if (isEmpty(subject)) {
            throw new IllegalArgumentException("[license.create.subject]不能为空");
        }
        final String notAfter = licenseCheck.getNotAfter();
        if (isEmpty(notAfter)) {
            throw new IllegalArgumentException("[license.create.not-after]不能为空");
        }
    }
}
