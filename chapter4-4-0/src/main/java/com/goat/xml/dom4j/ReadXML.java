package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 读取 xml 测试
 */
public class ReadXML extends MyBase {

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
            Student student = new Student();
            int	rollNumber = getAttributeValue(node, "rollnumber");
            student.setRollNumber(rollNumber);
            String firstName = getPropertyValue(node, "firstname");
            student.setFirstName(firstName);
            String lastName = getPropertyValue(node, "lastname");
            student.setLastName(lastName);
            String  nickName = getPropertyValue(node, "nickname");
            student.setNickName(nickName);
            int marks = Integer.parseInt(getPropertyValue(node, "marks"));
            student.setMarks(marks);
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
