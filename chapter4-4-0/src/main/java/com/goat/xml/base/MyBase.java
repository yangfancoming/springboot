package com.goat.xml.base;

import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 64274 on 2019/7/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/5---19:03
 */
public class MyBase {

    protected static final String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\students.xml";

    protected File file ;
    protected Document document ;
    protected SAXReader reader ;

    public MyBase()  {
        this.file = new File(path);
        this.reader = new SAXReader();
        try {
            this.document = this.reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected  void add(Student st, Element root) {
        Element student = root.addElement("student").addAttribute("rollnumber", String.valueOf(st.getRollNumber()));
        student.addElement("firstname").addText(st.getFirstName());
        student.addElement("lastname").addText(st.getLastName());
        student.addElement("nickname").addText(st.getNickName());
        student.addElement("marks").addText(String.valueOf(st.getMarks()));
    }

    protected void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);
        writer.write(document);
    }
}
