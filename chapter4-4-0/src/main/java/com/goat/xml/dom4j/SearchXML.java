package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.Node;
import org.junit.Test;


/**
 * 查询 xml 测试
 */
public class SearchXML extends MyBase {

    @Test
    public void test() {

        Student student = getStudent(document, 2);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not exist.");
        }
    }


    private static Student getStudent(Document document, int rollNumber) {
        String expression = "/class/student[@rollnumber=" + rollNumber + "]";
        Node node = document.selectSingleNode(expression);
        if (node != null) {
            Student student = new Student();
            student.setRollNumber(rollNumber);
            student.setFirstName(getPropertyValue(node, "firstname"));
            student.setLastName(getPropertyValue(node, "lastname"));
            student.setNickName(getPropertyValue(node, "nickname"));
            int marks = Integer.parseInt(getPropertyValue(node, "marks"));
            student.setMarks(marks);
            return student;
        }
        return null;
    }

    private static String getPropertyValue(Node node, String property) {
        return node.selectSingleNode(property).getText();
    }
}
