package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 读取 xml 测试
 */
public class ReadXML extends MyBase {

    /** 遍历 xml 文件中根元素下的 所有一级元素 */
    @Test
    public void elementIterator() {
        Element rootElement = document.getRootElement();
        for (Iterator iterator = rootElement.elementIterator(); iterator.hasNext();) {
            Element element = (Element)iterator.next();
            String name = element.getName();
            System.out.println(name);
        }
    }

    /** 遍历 xml 文件中根元素下的 所有  "/class/student"  student 元素  */
    @Test
    public void test() {
        String rootElement = document.getRootElement().getName();
        System.out.println("Root Element : " + rootElement);
        List<Student> students = getStudents(document);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> getStudents(Document document) {
        List<Student> list = new ArrayList<>();
        String expression = "/class/student";
        List<Node> nodes = document.selectNodes(expression);
        for (Node node : nodes) {
            Student student = new Student(getAttributeValue(node, "rollnumber"),getPropertyValue(node, "firstname"),getPropertyValue(node, "lastname"),getPropertyValue(node, "nickname"),Integer.parseInt(getPropertyValue(node, "marks")));
            list.add(student);
        }
        return list;
    }

    private static String getPropertyValue(Node node, String property) {
        return node.selectSingleNode(property).getText();
    }

    private static int getAttributeValue(Node node, String attribute) {
        return Integer.parseInt(node.valueOf("@" + attribute));
    }
}
