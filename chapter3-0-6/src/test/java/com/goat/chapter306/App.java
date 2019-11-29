package com.goat.chapter306;

import com.goat.chapter306.util.ResourceUtil;
import com.goat.chapter306.xml.XmlBeanDefinitionReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---10:41
 */
public class App {


    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
        ResourceUtil resourceUtil = new ResourceUtil();
        InputStream inputStream = resourceUtil.getResource("tinyioc.xml");
        Document document = xmlBeanDefinitionReader.doLoadBeanDefinitions(inputStream);
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
        System.out.println(root);
    }


    protected void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }


    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        System.out.println(name);
        System.out.println(className);
    }
}
