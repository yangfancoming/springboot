package com.goat.xml.sax;


import com.goat.xml.bean.Book;
import com.goat.xml.handler.SAXParseHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * 用SAX方式读取xml文件
 * @author lune
 */
public class ReadXmlBySAX {

	private static List<Book> books = null;
	private  SAXParserFactory sParserFactory = null;
	private  SAXParser parser = null;

	public List<Book> getBooks(String fileName) throws Exception{
		SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = sParserFactory.newSAXParser();
		SAXParseHandler handler = new SAXParseHandler();
		parser.parse(fileName, handler);
		return handler.getBooks();
		
	}

	public static void main(String[] args) throws Exception {
        String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\books.xml";
        books = new ReadXmlBySAX().getBooks(path);
        for(Book book:books){
            System.out.println(book);
        }
	}

}
