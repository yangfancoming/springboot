/**
 * CountriesPortService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;
import java.net.URL;

public interface CountriesPortService extends javax.xml.rpc.Service {
     String getCountriesPortSoap11Address();

     CountriesPort getCountriesPortSoap11() throws javax.xml.rpc.ServiceException;

     CountriesPort getCountriesPortSoap11(URL portAddress) throws javax.xml.rpc.ServiceException;
}
