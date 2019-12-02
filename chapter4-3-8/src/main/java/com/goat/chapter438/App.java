package com.goat.chapter438;

import com.goat.chapter438.util.DomUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---18:22
 */
public class App {

    @Test
    public void test() throws ParserConfigurationException, IOException, SAXException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("school.xml");
        Document doc = DomUtil.getDocumentByInputStream(inputStream);
        //        Document doc = DomUtil.getDocumentByInputStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-8\\src\\main\\resources\\school.xml");
        System.out.println("处理该文档的DomImplementation对象  = "+ doc.getImplementation());
        //得到文档名称为Student的元素的节点列表
        NodeList nList = doc.getElementsByTagName("Student");
        //遍历该集合，显示集合中的元素及其子元素的名字
        for(int i = 0; i< nList.getLength() ; i ++){
            Element node = (Element)nList.item(i);
            System.out.println("Name: "+ node.getElementsByTagName("Name").item(0).getFirstChild().getNodeValue());
            System.out.println("Num: "+ node.getElementsByTagName("Num").item(0).getFirstChild().getNodeValue());
            System.out.println("Classes: "+ node.getElementsByTagName("Classes").item(0).getFirstChild().getNodeValue());
            System.out.println("Address: "+ node.getElementsByTagName("Address").item(0).getFirstChild().getNodeValue());
            System.out.println("Tel: "+ node.getElementsByTagName("Tel").item(0).getFirstChild().getNodeValue());
        }
    }
}
