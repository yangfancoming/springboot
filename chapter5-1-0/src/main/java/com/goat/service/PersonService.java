package com.goat.service;


import com.goat.bean.Person;

public interface PersonService {
    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
