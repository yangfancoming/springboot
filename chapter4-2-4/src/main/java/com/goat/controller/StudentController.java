package com.goat.controller;

import com.goat.entity.Student;
import com.goat.dto.PageResponse;
import com.goat.service.IStudentService;
import com.goat.tools.PageableTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    // 测试地址：    http://localhost:8424/hello

    @RequestMapping("/test")
    public PageResponse<Student> hello(@RequestParam String aoData)  { //此处的aoData必须与前端传过来的参数aoData保持一致
        System.out.println(aoData);
        Page<Student> datas = studentService.findAll(PageableTools.myPage(0, 8));
        PageResponse<Student> pr = new PageResponse<>(datas.getContent(), datas.getTotalElements());
        return pr;
    }


}