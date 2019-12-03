package com.goat.xml.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/12/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/3---13:35
 *
 *实例 2 如果路径以双斜线 // 开头, 则表示选择文档中所有满足双斜线//之后规则的元素(无论层级关系)
 */
public class Dom4jXpath2 {

    public static String path11 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example2-1.xml";
    public static String path12 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example2-2.xml";

    public Element init(String path) throws DocumentException {
        Document document = new SAXReader().read( new File(path));
        return document.getRootElement();
    }

    @Test
    public void test1() throws DocumentException {
        Element rootElement = init(path11);
        List list = rootElement.selectNodes("//BBB");
        System.out.println(list.size());
    }

    @Test
    public void test2() throws DocumentException {
        Element rootElement = init(path12);
        List list = rootElement.selectNodes(" //DDD/BBB");
        System.out.println(list.size());
    }


}
