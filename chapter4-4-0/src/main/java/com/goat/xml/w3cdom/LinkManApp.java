package com.goat.xml.w3cdom;


import com.goat.xml.bean.Linkman;
import com.goat.xml.util.DomUtil;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.InputStream;
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
}
