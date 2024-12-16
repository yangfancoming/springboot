package com.goat.xml.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


@Controller
@RequestMapping("/hello")
public class HelloController {

    // 测试地址： http://localhost:8440/hello/test
    @RequestMapping("/test")
    public void test() throws JAXBException {
        User user = new User();
        user.setName("Alice");
        user.setAge(25);
        generateXml(user);
    }


    public void generateXml(User user) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
