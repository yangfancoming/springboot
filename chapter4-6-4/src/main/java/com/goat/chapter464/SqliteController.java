package com.goat.chapter464;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/person")
public class SqliteController {

    @Autowired
    PersonMapper personMapper;

    // 测试地址：  http://localhost:8464/person/test3

    @GetMapping("/test1")
	public List<Person> test1() {
		List<Person> list = personMapper.findAll();
		return list;
	}

    @GetMapping("/test2")
    public Person test2() {
        Person person = personMapper.select(1);
        return person;
    }

    @GetMapping("/test3")
    public List<Person> test3() {
        List<Person> person = personMapper.selectAll();
        return person;
    }

    @GetMapping("/test4")
    public int test4() {
        int person = personMapper.delete(1);
        return person;
    }
}
