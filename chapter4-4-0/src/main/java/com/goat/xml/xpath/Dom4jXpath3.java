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
 * 实例 3
 * 星号 * 表示选择所有由星号之前的路径所定位的元素
 */
public class Dom4jXpath3 {

    public static String path11 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example3-1.xml";
    public static String path12 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example3-2.xml";
    public static String path13 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example3-3.xml";

    public Element init(String path) throws DocumentException {
        Document document = new SAXReader().read( new File(path));
        return document.getRootElement();
    }

    @Test
    public void test1() throws DocumentException {
        Element rootElement = init(path11);
        List list = rootElement.selectNodes("/AAA/CCC/DDD/*");
        System.out.println(list.size());
    }

    @Test
    public void test2() throws DocumentException {
        Element rootElement = init(path12);
        List list = rootElement.selectNodes("/*/*/*/BBB");
        System.out.println(list.size());
    }

    @Test
    public void test3() throws DocumentException {
        Element rootElement = init(path12);
        List list = rootElement.selectNodes("//*");
        System.out.println(list.size());
    }
}
