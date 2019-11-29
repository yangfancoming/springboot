package com.goat.chapter439;

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
 */
public class App {

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
            reader.parse("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-9\\src\\main\\resources\\book.xml");
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
            reader.parse("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-9\\src\\main\\resources\\book.xml");
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
            myFilter.parse("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-9\\src\\main\\resources\\book.xml");
        } catch ( IOException e ) {
            System.out.println("读入文档时错: " + e.getMessage());
        } catch ( SAXException e ) {
            System.out.println("解析文档时错: " + e.getMessage());
        }
    }
}
