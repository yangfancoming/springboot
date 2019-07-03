package com.goat.easyui.jsp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.easyui.jsp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/student")
public class StudentController {

    //存储预返回页面的数据对象
    private Map<String, Object> result = new HashMap<>();

    private Map<Integer,Student> studentMap = new ConcurrentHashMap<>(16);

    private void init(){
        studentMap.put(1,new Student(1,"goat","西安","哈哈","三年二班"));
        studentMap.put(2,new Student(2,"goat","西安","哈哈","三年二班"));
        studentMap.put(3,new Student(3,"goat","西安","哈哈","三年二班"));
        studentMap.put(4,new Student(4,"goat","西安","哈哈","三年二班"));
    }

    /**
     * 分页查询学生信息列表:根据学生与班级名查询指定/全部学生信息列表
     */
    @PostMapping("/get")
    @ResponseBody
    public Map<String, Object> list(Integer page, Integer rows, String studentname, String clazzname) {
        init();
        result.clear();
        PageHelper.startPage(page, rows);
        List<Student> valueList = new ArrayList<>(studentMap.values());//map转list
        PageInfo<Student> pageInfo = new PageInfo<>(valueList);
        long total = pageInfo.getTotal();
        List<Student> studentList = pageInfo.getList();
        result.put("total", total);
        result.put("rows", studentList);
        return result;
    }


    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> add(Student student) {
        result.put("success", true);
        return result;
    }
//
//    /**
//     * @description: 根据id修改指定的学生信息
//     * @param: student
//     * @date: 2019-06-17 5:29 PM
//     * @return: java.util.Map<java.lang.String, java.lang.Object>
//     */
//    @PostMapping("/editStudent")
//    @ResponseBody
//    public Map<String, Object> editStudent(Student student) {
//        if (studentService.update(student) > 0) {
//            result.put("success", true);
//        } else {
//            result.put("success", false);
//            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
//        }
//        return result;
//    }
//
//
//    /**
//     * @description: 根据id删除指定的学生信息
//     * @param: ids
//     * @date: 2019-06-17 5:30 PM
//     * @return: java.util.Map<java.lang.String, java.lang.Object>
//     */
//    @PostMapping("/deleteStudent")
//    @ResponseBody
//    public Map<String, Object> deleteStudent(@RequestParam(value = "ids[]", required = true) Integer[] ids) {
//
//        if (studentService.deleteById(ids) > 0) {
//            result.put("success", true);
//        } else {
//            result.put("success", false);
//        }
//        return result;
//    }


}