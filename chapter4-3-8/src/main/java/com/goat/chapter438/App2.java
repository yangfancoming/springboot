package com.goat.chapter438;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 64274 on 2019/7/27.
 *
 * @ Description: w3cdom
 * @ author  山羊来了
 * @ date 2019/7/27---14:51
 */
public class App2 {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    InputStream in;
    Document doc;
    Element root;


    @Before
    public void before() throws Exception {
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        /**   使用 绝对路径名的方式 创建 Document
         String fileName = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\university.xml";
         Document doc = db.parse(fileName);
         */

        /**  使用 流的方式 创建 Document
         *  1.在springboot 类路径下添加配置文件 university.xml
         *  2.pom.xml 文件加入 <resources> maven编译xml   并生成到 类路径下 以便代码读取
         */
        in = this.getClass().getClassLoader().getResourceAsStream("university.xml");
        doc = db.parse(in);
        root = doc.getDocumentElement(); // root <university>
    }




    @Test
    public void read()   {
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



    @Test
    public void write() throws IOException, TransformerException {
        // 修改属性
        root.setAttribute("name", "tsu");
        NodeList collegeNodes = root.getChildNodes();
        for (int i = 0; i <collegeNodes.getLength() - 1; i++) {
            // 删除节点
            Node college = collegeNodes.item(i);
            if (college.getNodeType() == Node.ELEMENT_NODE) {
                String collegeName = college.getAttributes().getNamedItem("name").getNodeValue();
                if ("c1".equals(collegeName) || "c2".equals(collegeName)) {
                    root.removeChild(college);
                } else if ("c3".equals(collegeName)) {
                    Element newChild = doc.createElement("class");
                    newChild.setAttribute("name", "c4");
                    college.appendChild(newChild);
                }
            }
        }

        // 新增节点
        Element addCollege = doc.createElement("college");
        addCollege.setAttribute("name", "c5");
        root.appendChild(addCollege);
        Text text = doc.createTextNode("text");
        addCollege.appendChild(text);

        // 将修改后的文档保存到文件
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transFormer = transFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        File file = new File("src/main/resource/university-modify.xml");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        StreamResult xmlResult = new StreamResult(out);
        transFormer.transform(domSource, xmlResult);
        System.out.println(file.getAbsolutePath());

    }
}
