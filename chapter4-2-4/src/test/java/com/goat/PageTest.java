package com.goat;


import com.goat.entity.Student;
import com.goat.service.IStudentService;
import com.goat.tools.PageableTools;
import com.goat.tools.SortDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PageTest {

    @Autowired
    private IStudentService studentService;

    List<Student> users = new ArrayList<>();

    public void init(){
        users.add(new Student("AAA", "10"));
        users.add(new Student("BBB", "20"));
        users.add(new Student("CCC", "30"));
        users.add(new Student("DDD", "30"));
        users.add(new Student("EEE", "30"));
        users.add(new Student("FFF", "30"));
        users.add(new Student("GGG", "30"));
        users.add(new Student("HHH", "30"));
        users.add(new Student("III", "30"));
        users.add(new Student("JJJ", "30"));

        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
        users.add(new Student("JJJ", "30"));
    }
    // 插入测试数据
    @Test
    public void save() {
        init();
        studentService.saveAll(users);
    }

    @Test
    public void test1() {
//        Pageable pageable =new PageRequest(0, 5);
        Pageable pageable = PageRequest.of(2, 6);
        Page<Student> datas = studentService.findAll(pageable);
        print(datas);
    }

    @Test
    public void test2() {
        Page<Student> datas = studentService.findAll(PageableTools.myPage(0));
        print(datas);
    }

    @Test
    public void test3() {
        Page<Student> datas = studentService.findAll(PageableTools.myPage(0, 5));
        print(datas);
    }

    @Test
    public void test4() {
        Pageable pageable = PageableTools.basicPage(1, 5, new SortDto("id"));
        Page<Student> datas = studentService.findAll(pageable);
        print(datas);

        Page<Student> datas2 = studentService.findAll(PageableTools.basicPage(1, 5, new SortDto("ASC", "id")));
        print(datas2);
    }

    private void print(Page<Student> datas) {
        System.out.println("总条数："+datas.getTotalElements());
        System.out.println("总页数："+datas.getTotalPages());
        for(Student u : datas) {
            System.out.println(u.getId()+"===="+u.getUserName());
        }
    }
}
