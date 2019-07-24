package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddStudent extends MyBase {


    @Test
    public void test() throws IOException {
        Student student = new Student(321,"11","22","33",321);
        addStudent(student, document);
        FileOutputStream fos = new FileOutputStream(file);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);
        writer.write(document);
        System.out.println("写入 students.xml  成功！");
    }

    private static void addStudent(Student st, Document document) {
        Element root = document.getRootElement();
        add(st, root);
    }


}
