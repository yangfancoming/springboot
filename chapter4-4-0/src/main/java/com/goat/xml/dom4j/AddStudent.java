package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AddStudent extends MyBase {

//    fuck.xml
//    test.xml  创建内存文件  临时文件在内存中
    @Test
    public void test() throws IOException {

        File file = File.createTempFile("fuck", ".xml");

        Student student = new Student(987,"fck","sd","xz",965);
        Element root = document.getRootElement();
        StringBuffer see1 = see(file);
        System.out.println("see1" + see1);
        add(student, root);
        save(file);
        StringBuffer see2 = see(file);
        System.out.println("see2" + see2);
        System.out.println("写入 students.xml  成功！");
    }

    @Test
    public void create() throws IOException {
        Student student = new Student(321,"11","22","33",321);
        Element root = document.getRootElement();
        add(student, root);
        save(file);
        System.out.println("写入 students.xml  成功！");
    }



}
