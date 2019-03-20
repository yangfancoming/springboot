package com.goat.controller;

import com.goat.domain.Person;
import com.goat.domain.Pet;
import com.goat.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---14:39
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    /**   为 person 添加外键对象 pet
     http://localhost:8421/person/test1
     */
    @GetMapping("/test1")
    public Person test1(){
        Person person = new Person();
        person.setName("goat");
        Pet pet = new Pet();
        pet.setAge(11);
        pet.setNickName("gaga");
        person.setPet(pet);
        return personRepository.save(person);
    }

    /**  将外键 pet 设置为 null
     http://localhost:8421/person/test2
    */
    @GetMapping("/test2")
    public Person test2(){
        Person one = personRepository.getOne(2L);
        one.setPet(null);
        return personRepository.save(one);
    }

}
