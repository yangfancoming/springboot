package com.goat.client;

import com.goat.config.LicenseCommon;
import de.schlichtherle.license.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.prefs.Preferences;

/**
 * 验证license
 *
 * @author futureX
 */
public class VerifyLicense {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyLicense.class);

    /**
     * 验证（证书使用者端执行）
     *
     * @param licenseCommon 公共属性
     * @return
     */
    public boolean verify(LicenseCommon licenseCommon) {
        final LicenseParam licenseParam = this.initLicenseParams(licenseCommon);
        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(licenseParam);
        // 安装证书
        try {
            licenseManager.install(new File(licenseCommon.getLicensePath()));
        } catch (Exception e) {
            LOGGER.error("证书安装失败", e);
            return false;
        }
        // 验证证书
        try {
            LicenseContent content = licenseManager.verify();
            // TODO 可以在这里验证其他参数，如mac地址
        } catch (Exception e) {
            LOGGER.error("证书验证失败", e);
            return false;
        }
        return true;
    }

    /**
     * 初始化生成证书时需要的参数
     *
     * @param licenseCommon
     * @return
     */
    private LicenseParam initLicenseParams(LicenseCommon licenseCommon) {
        Preferences preference = Preferences.userNodeForPackage(VerifyLicense.class);
        // 设置对证书内容加密的对称密码
        CipherParam cipherParam = new DefaultCipherParam(licenseCommon.getStorepass());
        // 参数1,2从哪个Class.getResource()获得密钥库; 参数3密钥库的别名; 参数4密钥库存储密码; 参数5密钥库密码
        // For security reasons a client application is not allowed to provide private keys or passwords for private keys in a Java keystore!
        KeyStoreParam keyStoreParam = new DefaultKeyStoreParam(VerifyLicense.class, licenseCommon.getResource(), licenseCommon.getAlias(), licenseCommon.getStorepass(), null);
        LicenseParam licenseParams = new DefaultLicenseParam(licenseCommon.getSubject(), preference, keyStoreParam, cipherParam);
        return licenseParams;
    }

}