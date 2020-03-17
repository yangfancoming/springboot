package com.goat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goat.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PersonController {

	@Autowired
    ObjectMapper mapper;

    //    http://localhost:8223/person1  Person类中是 userName  输入的json中是user-name 使用反序列化器后 也可以正常解析
    @GetMapping("person1")
    public Person readJsonAsObject() throws IOException {
        String json = "{\"user-name\":\"mrbird\"}";
        Person person = mapper.readValue(json, Person.class);
        return person;
    }


    // http://localhost:8223/person2   序列化器导致 userNane 变成 {"user-name":"goat"}
    @RequestMapping("person2")
    @ResponseBody
    public String serialization() throws JsonProcessingException {
        Person person = new Person("goat",23);
        String str = mapper.writeValueAsString(person);
        return str;
    }

}
