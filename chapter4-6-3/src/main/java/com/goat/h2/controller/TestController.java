package com.goat.h2.controller;

import com.goat.h2.dao.StudentMapper;
import com.goat.h2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/21---11:51
 */
@RestController
public class TestController {


    @Autowired
    StudentMapper studentMapper;
    //    http://localhost:8463/test
    @GetMapping("/test")
    public void test(){
        Student stu = new Student("a", 0, "x");
        studentMapper.insert(stu);
        List<Student> studentList = studentMapper.selectAll();
        System.out.println(studentList);
    }
}
