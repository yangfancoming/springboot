package com.goat.webservice.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AppService {

    @WebMethod
    String getUserName(@WebParam(name = "id") String id)  ;

    @WebMethod
    String getUser(String id)  ;


    @WebMethod
    String test2(String id)  ;

    @WebMethod
    String test(String id,int num,String name,Boolean mark)  ;
}
