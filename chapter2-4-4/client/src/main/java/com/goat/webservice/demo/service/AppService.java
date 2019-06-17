package com.goat.webservice.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AppService {

    @WebMethod
    Object test(@WebParam(name = "a") int a,int b)  ;

    @WebMethod
    String test2(String id)  ;

    Object fuck(int a,int b);

    @WebMethod
    String getUserName(@WebParam(name = "id") String id)  ;

    @WebMethod
    String getUser(String id)  ;

}
