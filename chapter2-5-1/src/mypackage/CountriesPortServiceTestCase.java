/**
 * CountriesPortServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public class CountriesPortServiceTestCase extends junit.framework.TestCase {
    public CountriesPortServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testCountriesPortSoap11WSDL() throws Exception {

        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new mypackage.CountriesPortServiceLocator().getCountriesPortSoap11Address() + "?WSDL"); // doit  这里报错
        javax.xml.rpc.Service service = serviceFactory.createService(url, new mypackage.CountriesPortServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1CountriesPortSoap11GetCountry() throws Exception {
        mypackage.CountriesPortSoap11Stub binding;
        try {
            binding = (mypackage.CountriesPortSoap11Stub)
                          new mypackage.CountriesPortServiceLocator().getCountriesPortSoap11();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        mypackage.GetCountryResponse value = null;
        value = binding.getCountry(new mypackage.GetCountryRequest());
        System.out.println(value);
        // TBD - validate results
    }

}
