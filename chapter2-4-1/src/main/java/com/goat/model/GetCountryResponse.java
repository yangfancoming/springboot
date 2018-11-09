
package com.goat.model;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.yourcompany.com/webservice}country"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"country"})

@XmlRootElement(name = "getCountryResponse", namespace = "http://www.yourcompany.com/webservice")
public class GetCountryResponse {

    @XmlElement(namespace = "http://www.yourcompany.com/webservice", required = true)
    protected Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = value;
    }

}
