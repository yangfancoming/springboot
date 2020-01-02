package com.goat.xml.sax.demo02;

import org.junit.Test;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2019/11/29.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---11:55
 *
 *     SAX的设计实现与DOM是完全不同的！DOM处理XML文档是基于将XML文档解析成树状模型，放入内存进行处理。
 *     而SAX则是采用基于事件驱动的处理模式，它将XML文档转化成一系列的事件，由单独的事件处理器来决定如何处理。
 *     为了 了解如何使用SAX API处理XML文档，这里先介绍一下SAX所使用的基于事件驱动的处理模式。
 */
public class App {

    private static final String xmlFilePath = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\book.xml";
    @Test
    public void test() {
        try {
            // 初始化reader
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
            // 创建ContentHandler的实例
            ContentHandler contentHandler = new MyContentHandler();
            // 在reader中注册实例化的ContentHandler
            reader.setContentHandler(contentHandler);
            ErrorHandler errorHandler = new MyErrorHandler();
            reader.setErrorHandler(errorHandler);
            // 开始解析文档
            reader.parse(xmlFilePath);
        } catch ( IOException e ) {
            System.out.println("读入文档时错: " + e.getMessage());
        } catch ( SAXException e ) {
            System.out.println("解析文档时错: " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            // 初始化reader
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
            // 创建ContentHandler的实例
            DefaultHandler contentHandler = new MyDefaultHandler();
            // 在reader中注册实例化的ContentHandler
            reader.setContentHandler(contentHandler);
            reader.setErrorHandler(contentHandler);
            // 开始解析文档
            reader.parse(xmlFilePath);
        } catch ( IOException e ) {
            System.out.println("读入文档时错: " + e.getMessage());
        } catch ( SAXException e ) {
            System.out.println("解析文档时错: " + e.getMessage());
        }
    }


    @Test
    public void tes3() {
        try {
            // 初始化reader
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
            //初始化过滤器
            XMLFilter myFilter = new MyFilter(reader);
            // 创建ContentHandler的实例
            DefaultHandler contentHandler = new MyDefaultHandler();
            // 在reader中注册实例化的ContentHandler
            myFilter.setContentHandler(contentHandler);
            myFilter.setErrorHandler(contentHandler);
            // 开始解析文档
            myFilter.parse(xmlFilePath);
        } catch ( IOException e ) {
            System.out.println("读入文档时错: " + e.getMessage());
        } catch ( SAXException e ) {
            System.out.println("解析文档时错: " + e.getMessage());
        }
    }
}
