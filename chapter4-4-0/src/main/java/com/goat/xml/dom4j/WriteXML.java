package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 写入 xml 测试
 */
public class WriteXML extends MyBase {

    @Test
    public void test() throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("class");
        Student student = new Student(1,"11","22","33",4);
        add(student, root);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos,format);
        writer.write(document);
        System.out.println("写入 students.xml  成功！");
    }

}
