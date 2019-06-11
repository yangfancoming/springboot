package com.goat.webservice.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface AppService {

    @WebMethod
    String getUserName(@WebParam(name = "id") String id) ;

    @WebMethod
    public String getUser(String id) ;
}
