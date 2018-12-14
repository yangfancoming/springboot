package com.goat.client;


import com.goat.config.LicenseCheck;
import com.goat.config.LicenseCommon;
import de.schlichtherle.license.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;

/**
 * 生成证书
 *
 * @author futureX
 */
public class CreateLicense {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateLicense.class);

    /**
     * 日期格式
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd";


    /**
     * 创建license（证书发布者端执行）
     * @param licenseCommon 公共属性
     * @param licenseCheck  受检查属性
     * @return
     */
    public boolean create(LicenseCommon licenseCommon, LicenseCheck licenseCheck) {
        LicenseParam licenseParam = this.initLicenseParams(licenseCommon);
        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(licenseParam);
        LicenseContent licenseContent = this.createLicenseContent(licenseCommon, licenseCheck);
        File file = new File(licenseCommon.getLicensePath());
        try {
            licenseManager.store(licenseContent, file);
        } catch (LicenseContentException e) {
            LOGGER.error("生成证书内容异常,请检查配置", e);
            return false;
        } catch (Exception e) {
            LOGGER.error("生成证书错误", e);
            return false;
        }
        return true;
    }

    /**
     * 初始化生成证书时需要的参数
     * @param licenseCommon
     * @return
     */
    private LicenseParam initLicenseParams(LicenseCommon licenseCommon) {
        Preferences preference = Preferences.userNodeForPackage(CreateLicense.class);
        // 设置对证书内容加密的对称密码
        CipherParam cipherParam = new DefaultCipherParam(licenseCommon.getStorepass());
        // 如果keypass为空，则设置跟storepass保持一致
        if (StringUtils.isEmpty(licenseCommon.getKeypass())) {
            licenseCommon.setKeypass(licenseCommon.getStorepass());
        }
        // 参数1,2从哪个Class.getResource()获得密钥库; 参数3密钥库的别名; 参数4密钥库存储密码; 参数5密钥库密码
        KeyStoreParam keyStoreParam = new DefaultKeyStoreParam(CreateLicense.class, licenseCommon.getResource(), licenseCommon.getAlias(), licenseCommon.getStorepass(), licenseCommon.getKeypass());
        LicenseParam licenseParams = new DefaultLicenseParam(licenseCommon.getSubject(), preference, keyStoreParam, cipherParam);
        return licenseParams;
    }

    /**
     * 从外部配置拿到证书的内容
     * @param licenseCommon 来自公共的属性
     * @param licenseCheck  来自配置的属性
     * @throws ParseException 日期转换异常
     */
    private final LicenseContent createLicenseContent(LicenseCommon licenseCommon, LicenseCheck licenseCheck) {
        final DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        final LicenseContent content = new LicenseContent();
        try {
            final String issuedTime = licenseCheck.getIssuedTime();
            if (! StringUtils.isEmpty(issuedTime)) {
                content.setIssued(format.parse(issuedTime));
            }
            final String notBefore = licenseCheck.getNotBefore();
            if (! StringUtils.isEmpty(notBefore)) {
                content.setNotBefore(format.parse(notBefore));
            }
            final String notAfter = licenseCheck.getNotAfter();
            if (! StringUtils.isEmpty(notAfter)) {
                content.setNotAfter(format.parse(notAfter));
            }
        } catch (ParseException e) {
            LOGGER.error("日期转换异常", e);
            System.exit(-1);
        }

        final StringBuilder sb = new StringBuilder();
        sb.append("CN=").append(licenseCheck.getCommonName()).append(", ")
                .append("L=").append(licenseCheck.getLocality()).append(", ")
                .append("ST=").append(licenseCheck.getLocality()).append(", ")
                .append("C=").append(licenseCheck.getLocality());
        X500Principal holderAndIssurer = new X500Principal(sb.toString());
        content.setHolder(holderAndIssurer);
        content.setIssuer(holderAndIssurer);
        content.setConsumerType(licenseCheck.getConsumerType());
        content.setConsumerAmount(licenseCheck.getConsumerAmount());
        content.setInfo(licenseCheck.getInfo());
        // 扩展mac校验
        content.setExtra(licenseCheck.getMacAddress());
        content.setSubject(licenseCommon.getSubject());
        return content;
    }
}