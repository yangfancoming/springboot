/**
 * Country.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public class Country  implements java.io.Serializable {
    private java.lang.String name;

    private int population;

    private java.lang.String capital;

    private mypackage.Currency currency;

    public Country() {
    }

    public Country(
           java.lang.String name,
           int population,
           java.lang.String capital,
           mypackage.Currency currency) {
           this.name = name;
           this.population = population;
           this.capital = capital;
           this.currency = currency;
    }


    /**
     * Gets the name value for this Country.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Country.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the population value for this Country.
     * 
     * @return population
     */
    public int getPopulation() {
        return population;
    }


    /**
     * Sets the population value for this Country.
     * 
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }


    /**
     * Gets the capital value for this Country.
     * 
     * @return capital
     */
    public java.lang.String getCapital() {
        return capital;
    }


    /**
     * Sets the capital value for this Country.
     * 
     * @param capital
     */
    public void setCapital(java.lang.String capital) {
        this.capital = capital;
    }


    /**
     * Gets the currency value for this Country.
     * 
     * @return currency
     */
    public mypackage.Currency getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Country.
     * 
     * @param currency
     */
    public void setCurrency(mypackage.Currency currency) {
        this.currency = currency;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Country)) return false;
        Country other = (Country) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.population == other.getPopulation() &&
            ((this.capital==null && other.getCapital()==null) || 
             (this.capital!=null &&
              this.capital.equals(other.getCapital()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getPopulation();
        if (getCapital() != null) {
            _hashCode += getCapital().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Country.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "country"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("population");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "population"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capital");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "capital"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.yourcompany.com/webservice", "currency"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
