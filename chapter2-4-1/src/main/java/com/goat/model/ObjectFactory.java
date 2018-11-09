
package com.goat.model;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }


    public GetCountryRequest createGetCountryRequest() {
        return new GetCountryRequest();
    }


    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }


    public Country createCountry() {
        return new Country();
    }

}
