package com.goat.xml.w3cdom;


import com.goat.xml.bean.Linkman;
import com.goat.xml.util.DomUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---18:22
 * 
 *    Document doc = builder.parse(new File("/linkman.xml")); //  E:\linkman.xml (系统找不到指定的文件。)
 *    Document doc = builder.parse(new File("linkman.xml")); // E:\Code\J2EE_code\MySpringBoot\springboot\chapter4-3-8\linkman.xml (系统找不到指定的文件。)
 *    Document doc = builder.parse(new File("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-8\\src\\main\\resources\\linkman.xml")); // ok
 */
public class LinkManApp {

    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("linkman.xml");

    @Test
    public void selectOneById() throws IOException, SAXException, ParserConfigurationException {
        Linkman lkm = DomUtil.selectOneById("5",inputStream);
        System.out.println(lkm);
    }

    @Test
    public void delete() throws SAXException, TransformerException, ParserConfigurationException, IOException {
        DomUtil.delete("6");
    }

    @Test
    public void insert()  {
        Linkman linkman = new Linkman();
        linkman.setId("6");
        linkman.setName("666");
        linkman.setAddress("66666");
        linkman.setEmail("66666666@163.com");
        DomUtil.insert(linkman,inputStream);
    }

    @Test
    public void update() throws IOException, SAXException, ParserConfigurationException {
        Linkman lkm = DomUtil.selectOneById("5",inputStream);
        lkm.setAddress("fuck");
        DomUtil.update(lkm);
    }

    @Test
    public void selectAll()  {
        List<Linkman> list = DomUtil.selectAll();
        for (Linkman lm : list) {
            System.err.println(lm);
        }
    }


    @Test
    public void save() throws TransformerException, ParserConfigurationException {
        // 创建DocumentBuilderFactory对象
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        // 创建DocumentBuilder对象
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // 创建根元素
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("employees");
        doc.appendChild(rootElement);

        // 创建子元素和文本节点
        Element employee = doc.createElement("employee");
        rootElement.appendChild(employee);

        Element name = doc.createElement("name");
        Text nameText = doc.createTextNode("John Doe");
        name.appendChild(nameText);
        employee.appendChild(name);

        Element age = doc.createElement("age");
        Text ageText = doc.createTextNode("30");
        age.appendChild(ageText);
        employee.appendChild(age);

        // 生成XML文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        File file = new File("440.xml");
        StreamResult result = new StreamResult(file);

        // 输出XML文件
        transformer.transform(source, result);
        System.out.println("XML文件生成成功！");
        System.out.println(file);
        OutputStream outputStream = result.getOutputStream();

    }
}
