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
 * 实例 4
 * 方块号里的表达式可以进一步的指定元素, 其中数字表示元素在选择集里的位置, 而last()函数则表示选择集中的最后一个元素.
 */
public class Dom4jXpath4 {

    public static String path11 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example4-1.xml";
    public static String path12 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xpath\\example4-2.xml";

    public Element init(String path) throws DocumentException {
        Document document = new SAXReader().read( new File(path));
        return document.getRootElement();
    }

    @Test
    public void test1() throws DocumentException {
        Element rootElement = init(path11);
        List list = rootElement.selectNodes("/AAA/BBB[1]");
        System.out.println(list.size());
    }

    @Test
    public void test2() throws DocumentException {
        Element rootElement = init(path12);
        List list = rootElement.selectNodes("/AAA/BBB[last()]");
        System.out.println(list.size());
    }


}
