package com.goat.client;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

public class LicenseManagerHolder {
	
	private static LicenseManager licenseManager;
 
	public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParam) {
    	if (licenseManager == null) {
    		licenseManager = new LicenseManager(licenseParam);
    	}
    	return licenseManager;
    }
}