package com.goat.xml.base;

import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by 64274 on 2019/7/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/5---19:03
 */
public class MyBase {

//    public static String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\students.xml";
    public static String path = "D:\\code\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xml\\test.xml";
//    public static String path = "goat.xml";

    protected File file ;
    protected Document document ;
    protected SAXReader reader ;

    public MyBase()  {
        this.file = new File(path);
        // 创建解析器
        this.reader = new SAXReader();
        try {
            // 解析器解析指定xml文件
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

    protected void save(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);
        writer.write(document);
        writer.close();
    }


    protected StringBuffer see(File file){
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf;
    }
}
