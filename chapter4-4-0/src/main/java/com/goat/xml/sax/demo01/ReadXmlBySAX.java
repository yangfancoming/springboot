package com.goat.xml.sax.demo01;


import com.goat.xml.bean.Book;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * 用SAX方式读取xml文件
 */
public class ReadXmlBySAX {

	private static List<Book> books = null;

	public List<Book> getBooks(String fileName) throws Exception{
	    // 创建 sax解析器工厂
		SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
		// 创建 sax解析器(扫描器)
		SAXParser parser = sParserFactory.newSAXParser();
		// 创建 sax处理器
		MyParseHandler handler = new MyParseHandler();
		// 开启边扫描边处理  P1= 指定要扫描的xml文件  P2= 指定扫描事件分发到哪个处理器进行处理
		parser.parse(fileName, handler);
		return handler.getBooks();
		
	}

	public static void main(String[] args) throws Exception {
        String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\books.xml";
//        String path = "src/books.xml";
        books = new ReadXmlBySAX().getBooks(path);
        for(Book book:books){
            System.out.println(book);
        }
	}

}
