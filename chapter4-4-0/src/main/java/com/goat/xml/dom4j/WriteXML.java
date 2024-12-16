package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
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


    @Test
    public void test2() throws IOException{
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点rss
            Element rss = document.addElement("rss");
            // 3、向rss节点添加version属性
            rss.addAttribute("version", "2.0");
            // 4、生成子节点及子节点内容
            Element channel = rss.addElement("channel");
            Element title = channel.addElement("title");
            title.setText("国内最新新闻");
            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");


            // 6、生成xml文件
//            File file = new File("rss.xml");
            File file = new File("src/rss.xml");
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            // 设置是否转义，默认使用转义字符
            writer.setEscapeText(false);
            writer.write(document);
            writer.close();
            System.out.println("生成rss.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成rss.xml失败");
        }
    }

}
