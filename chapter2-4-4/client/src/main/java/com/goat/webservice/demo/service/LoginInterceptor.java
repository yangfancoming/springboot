package com.goat.webservice.demo.service;


import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;


public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private String username;
    private String password;

    public LoginInterceptor(String username, String password) {
        super(Phase.PREPARE_SEND);//设置在发送请求前阶段进行拦截
        this.username=username;
        this.password=password;
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        List<Header> headers = soapMessage.getHeaders();
        Document doc = DOMUtils.createDocument();
        Element auth = doc.createElementNS("service.demo.webservice.goat.com/","SecurityHeader"); // 对应 targetNamespace ="http://webservice.demo.example.com/"  http://service.server.webservice.demo.goat.com/
        Element UserName = doc.createElement("username");
        Element UserPass = doc.createElement("password");

        UserName.setTextContent(username);
        UserPass.setTextContent(password);

        auth.appendChild(UserName);
        auth.appendChild(UserPass);

        headers.add(0, new Header(new QName("SecurityHeader"),auth));
    }
}