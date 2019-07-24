package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;


/**
 * 写入 xml 测试
*/
public class WriteXML extends MyBase {

    @Test
    public void test() throws IOException{
        BufferedReader input=null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("class");
            Student student = new Student(1,"11","22","33",4);
            writeXML(root,student);
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fos,format);
            writer.write(document);
            System.out.println("写入 students.xml  成功！");
        }finally{
            if(input!=null){
                input.close();
            }
        }
    }

    private static void writeXML(Element root, Student st) {
        Element student = root.addElement("student").addAttribute("rollnumber", String.valueOf(st.getRollNumber()));
        student.addElement("firstname").addText(st.getFirstName());
        student.addElement("lastname").addText(st.getLastName());
        student.addElement("nickname").addText(st.getNickName());
        student.addElement("marks").addText(String.valueOf(st.getMarks()));
    }

}
