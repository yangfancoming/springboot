package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Element;
import org.junit.Test;

import java.io.IOException;

public class AddStudent extends MyBase {


    @Test
    public void test() throws IOException {
        Student student = new Student(321,"11","22","33",321);
        Element root = document.getRootElement();
        add(student, root);
        save();
        System.out.println("写入 students.xml  成功！");
    }

    @Test
    public void create() throws IOException {
        Student student = new Student(321,"11","22","33",321);
        Element root = document.getRootElement();
        add(student, root);
        save();
        System.out.println("写入 students.xml  成功！");
    }
}
