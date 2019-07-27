package com.goat.xml.dom;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by 64274 on 2019/7/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/27---14:51
 */
public class App {

    @Test
    public void test() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        /**   使用 绝对路径名的方式 创建 Document
         String fileName = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\university.xml";
         Document doc = db.parse(fileName);
        */

        /**  使用 流的方式 创建 Document
         *  1.在springboot 类路径下添加配置文件 university.xml
         *  2.pom.xml 文件加入 <resources> maven编译xml   并生成到 类路径下 以便代码读取
        */
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("university.xml");
        Document doc = db.parse(in);

        Element root = doc.getDocumentElement(); // root <university>
        System.err.println(root.getAttribute("name"));
        // 所有 college 节点
        NodeList collegeNodes = root.getChildNodes();
        for (int i = 0; i < collegeNodes.getLength(); i++) {
            Node college = collegeNodes.item(i);
            if (college != null  && college.getNodeType() == Node.ELEMENT_NODE) {
                System.err.println("\t" +  college.getAttributes().getNamedItem("name").getNodeValue());
                // 所有 class 节点
                NodeList classNodes = college.getChildNodes();
                for (int j = 0; j < classNodes.getLength(); j++) {
                    Node clazz = classNodes.item(j);
                    if (clazz != null && clazz.getNodeType() == Node.ELEMENT_NODE) {
                        System.err.println("\t\t"+ clazz.getAttributes().getNamedItem("name") .getNodeValue());
                        // 所有 student
                        NodeList studentNodes = clazz.getChildNodes();
                        for (int k = 0; k < studentNodes.getLength(); k++) {
                            Node student = studentNodes.item(k);
                            if (student != null&& student.getNodeType() == Node.ELEMENT_NODE) {
                                System.err.print("\t\t\t" + student.getAttributes().getNamedItem("name").getNodeValue());
                                System.err.print(" " + student.getAttributes() .getNamedItem("sex").getNodeValue());
                                System.err.println(" " + student.getAttributes().getNamedItem("age").getNodeValue());
                            }
                        }
                    }
                }
            }
        }
    }
}
