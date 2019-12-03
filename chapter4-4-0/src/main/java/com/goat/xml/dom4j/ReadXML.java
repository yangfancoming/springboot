package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import com.goat.xml.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 读取 xml 测试
 */
public class ReadXML extends MyBase {


    @Test
    public void add() throws IOException {

        // 创建 <student> 节点
        Element student = DocumentHelper.createElement("student");
        // 创建 <firstname> 节点
        Element firstname = DocumentHelper.createElement("firstname");
        // 创建 <lastname> 节点
        Element lastname = DocumentHelper.createElement("lastname");
        // 创建 <nickname> 节点
        Element nickname = DocumentHelper.createElement("nickname");
        // 将 三个子节点  挂载到 主节点下
        student.add(firstname);
        student.add(lastname);
        student.add(nickname);
        // 将主节点 再挂载到 根节点下
        Element rootElement = document.getRootElement();
        rootElement.add(student);
        // 将 内存文档 写入磁盘文件  持久化
        FileOutputStream fos = new FileOutputStream(file);
        XMLWriter writer = new XMLWriter(fos);
        writer.write(document);
    }

    @Test
    public void read() {
        // 获取根元素
        Element rootElement = document.getRootElement();
        // 获取 所有的<student>节点列表
        List lists = rootElement.elements("student");
        // 获取列表中的第2个元素
        Element temp = (Element)lists.get(1);
        // 获取 第一个 <student> 节点中的 第一个  <firstname> 节点
        Element goat1 = temp.element("firstname");
        // 输出其文本
        System.out.println(goat1.getText()+ "----" + goat1.attributeValue("foo"));
    }

    @Test
    public void tst() {
        Element rootElement = document.getRootElement();
        list(rootElement);
    }
    /** 遍历 xml  递归 */
    public void list(Element element) {
        System.out.println(element.getName());
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()){
            Element next = (Element)iterator.next();
            list(next);
        }
    }

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
