package com.goat.xml.xpath;

import com.goat.xml.bean.Students;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/5---19:21
 */
public class DomXpathApp {

   public static List<Students> list = new ArrayList<>();//解析出来的数据用Stundent对象存储，用集合存储该对象

    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//实例化DocumentBuilderFactory对象
        DocumentBuilder bulider = dbf.newDocumentBuilder();
        String fileName = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\student.xml";
//        Document doc = bulider.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
        Document doc = bulider.parse(fileName);
        XPath xpath = XPathFactory.newInstance().newXPath();
        // 方式一：
        //使用XPath对象编译XPath表达式
        XPathExpression compile = xpath.compile("//student");//选取student节点
        //计算 XPath 表达式得到结果
        //节点集node-set转化为NodeList
        //将结果强制转化成 DOM NodeList
        NodeList nodes = (NodeList)compile.evaluate(doc, XPathConstants.NODESET);//获取student节点的所有节点

        // 方式二：
//        NodeList nodes = (NodeList)xpath.evaluate("//student", doc, XPathConstants.NODESET);

        for(int i=0;i<nodes.getLength();i++) {
            Students stu = new Students();
            NodeList childNodes = nodes.item(i).getChildNodes(); //获取一个student节点所有的子节点，返回集合
            //遍历所有子节点，获取节点的名称与数据，将其存与Students对象的属性进行匹配并存入到该对象
            for(int j=0;j<childNodes.getLength();j++) {
                test(stu, childNodes.item(j));
            }
            //获取 student节点的属性，将其存与Students对象的属性进行匹配并存入到该对象
            NamedNodeMap arr = nodes.item(i).getAttributes();
            for(int k=0;k<arr.getLength();k++) {
                test(stu, arr.item(k));
            }
            list.add(stu);
        }
        for(Students s:list) {//遍历输出测试
            System.out.println(s);
        }

    }

    public static void test(Students stu, Node item) {
        Node node = item;
        if ("name".equals(node.getNodeName())) {
            stu.setName(node.getTextContent());
        }
        if ("sex".equals(node.getNodeName())) {
            stu.setSex(node.getTextContent());
        }
        if ("id".equals(node.getNodeName())) {
            stu.setId(Integer.parseInt(node.getTextContent()));
        }
        if ("score".equals(node.getNodeName())) {
            stu.setSocre(Integer.parseInt(node.getTextContent()));
        }
    }

}
