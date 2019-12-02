package com.goat.chapter438;

import com.goat.chapter438.util.DomUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---18:22
 */
public class ClassApp {

    public ClassApp() throws IOException, SAXException, ParserConfigurationException {}

    Document doc = DomUtil.getDocumentByInputStream("src/classes.xml");


    // 递归遍历 xml
    @Test
    public void tes1t() {
        System.out.println("处理该文档的DomImplementation对象  = "+ doc.getImplementation());
        DomUtil.foreachNode(doc);
    }

    // 读取元素
    @Test
    public void test1(){
        // 获取 <学生> 元素列表
        NodeList nodeList = doc.getElementsByTagName("学生");
        // 获取第三个学生
        Element item = (Element)nodeList.item(2);
        // 获取第三个学生下的  <名字> 元素
        NodeList tempList = item.getElementsByTagName("名字");
        System.out.println(tempList.getLength());
    }

    // 读取元素下属性
    @Test
    public void test2(){
        // 获取 <学生> 元素列表
        NodeList nodeList = doc.getElementsByTagName("学生");
        // 获取第三个学生
        Element item = (Element)nodeList.item(2);
        // 获取第三个学生下 sex属性
        String sex = item.getAttribute("sex");
        System.out.println(sex);
    }

    // 插入
    @Test
    public void test3() throws TransformerException {
        // 创建一个学生节点
        Element element = doc.createElement("学生");
        element.setTextContent("小明");
        // 新建的节点 添加到根元素下
        doc.getDocumentElement().appendChild(element);
        DOMSource xmlSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult("src/classes.xml");
        // 将添加到内存的结果  保存到硬盘xml文件
        TransformerFactory.newInstance().newTransformer().transform(xmlSource,streamResult);
    }

    // 插入
    @Test
    public void test4() throws TransformerException {
        // 创建一个学生节点
        Element element1 = doc.createElement("学生");
        // 给节点设置 属性
        element1.setAttribute("goat","wahaha");
        // 创建 名字节点
        Element element2 = doc.createElement("名字");
        // 设置节点值
        element2.setTextContent("小明");

        Element element3 = doc.createElement("年龄");
        element3.setTextContent("11");

        Element element4 = doc.createElement("介绍");
        element4.setTextContent("我是介绍");

        //  将三个子节点  添加到 父节点上 （按顺序添加）
        element1.appendChild(element4);
        element1.appendChild(element3);
        element1.appendChild(element2);

        // 新建的节点 添加到根元素下
        doc.getDocumentElement().appendChild(element1);
        DOMSource xmlSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult("src/classes.xml");
        // 将添加到内存的结果  保存到硬盘xml文件
        TransformerFactory.newInstance().newTransformer().transform(xmlSource,streamResult);
    }

    // 删除 节点
    @Test
    public void test5() throws TransformerException {
        // 获取 <学生> 元素列表
        NodeList nodeList = doc.getElementsByTagName("学生");
        // 获取第4个学生
        Node item = nodeList.item(3);
        item.getParentNode().removeChild(item);

        DOMSource xmlSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult("src/classes.xml");
        // 将添加到内存的结果  保存到硬盘xml文件
        TransformerFactory.newInstance().newTransformer().transform(xmlSource,streamResult);
    }

    // 删除 节点 属性
    @Test
    public void test6() throws TransformerException {
        // 获取 <学生> 元素列表
        NodeList nodeList = doc.getElementsByTagName("学生");
        // 获取第3个学生
        Element item = (Element)nodeList.item(2);
        item.removeAttribute("sex");

        DOMSource xmlSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult("src/classes.xml");
        // 将添加到内存的结果  保存到硬盘xml文件
        TransformerFactory.newInstance().newTransformer().transform(xmlSource,streamResult);
    }

    // 修改 节点
    @Test
    public void test7() throws TransformerException {
        // 获取 <学生> 元素列表
        NodeList nodeList = doc.getElementsByTagName("学生");
        // 获取第1个学生
        Element item = (Element)nodeList.item(0);
        // 在第一个学生节点中 查找 “名字” 子节点
        NodeList temp = item.getElementsByTagName("名字");
        // 由于可能找到多个 “名字” 子节点  所以就取出第一个  进行修改
        temp.item(0).setTextContent("宋江");

        DOMSource xmlSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult("src/classes.xml");
        // 将添加到内存的结果  保存到硬盘xml文件
        TransformerFactory.newInstance().newTransformer().transform(xmlSource,streamResult);
    }
}
