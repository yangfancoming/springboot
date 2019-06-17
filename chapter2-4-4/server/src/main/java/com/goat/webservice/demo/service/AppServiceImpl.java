package com.goat.webservice.demo.service;

import javax.jws.WebService;

//name暴露的服务名称, targetNamespace:命名空间,设置为接口的包名倒写(默认是本类包名倒写). endpointInterface 接口地址全类路径名
@WebService(name = "test" ,targetNamespace ="http://service.demo.webservice.goat.com/" ,endpointInterface = "com.goat.webservice.demo.service.AppService")
public class AppServiceImpl implements AppService {

    @Override
    public String getUserName(String id) {
        System.out.println("===========================getUserName:"+id);
        return "webserviceServer--getUserName: my name is jw";
    }

    @Override
    public String getUser(String id) {
        System.out.println("===========================getUser:"+id);
        return "webserviceServer--getUserName: this is jw,18 years old";
    }

    @Override
    public String test(String id, int num, String name, Boolean mark) {
        System.out.println(id);
        System.out.println(num);
        System.out.println(name);
        System.out.println(mark);
        return "ok";
    }
}
