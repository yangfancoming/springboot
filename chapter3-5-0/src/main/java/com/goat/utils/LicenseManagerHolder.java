package com.goat.utils;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * Created by 64274 on 2018/12/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/13---20:47
 */

public class LicenseManagerHolder {
    private static LicenseManager licenseManager;
    private LicenseManagerHolder(){}
    public static synchronized LicenseManager getLicenseManager(LicenseParam param){
        if(licenseManager == null){
            licenseManager = new LicenseManager(param);
        }
        return licenseManager;
    }
}
