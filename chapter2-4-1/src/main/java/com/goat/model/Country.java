
package com.goat.model;

import javax.xml.bind.annotation.*;


/**
 * <p>country complex type
 * 
 * <p>
 * 
 * <pre>
 * &lt;complexType name="country">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currency" type="{http://www.yourcompany.com/webservice}currency"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "country", namespace = "http://www.yourcompany.com/webservice", propOrder = {
    "name",
    "population",
    "capital",
    "currency"
})
public class Country {

    @XmlElement(namespace = "http://www.yourcompany.com/webservice", required = true,name = "NAME")
    protected String name;
    @XmlElement(namespace = "http://www.yourcompany.com/webservice",name = "POPULATION")
    protected int population;
    @XmlElement(namespace = "http://www.yourcompany.com/webservice", required = true)
    protected String capital;
    @XmlElement(namespace = "http://www.yourcompany.com/webservice", required = true)
    @XmlSchemaType(name = "string")
    protected Currency currency;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }


    public int getPopulation() {
        return population;
    }

    public void setPopulation(int value) {
        this.population = value;
    }


    public String getCapital() {
        return capital;
    }


    public void setCapital(String value) {
        this.capital = value;
    }

    public Currency getCurrency() {
        return currency;
    }


    public void setCurrency(Currency value) {
        this.currency = value;
    }

}
