package com.goat.xml.jdom;

import com.goat.xml.bean.Book;
import org.jdom2.*;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用JDOM方式读取xml文件
 */
public class ReadXMLByJDom {

    private List<Book> books = null;
    private Book book = null;

    public List<Book> getBooks(String fileName){
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(new FileInputStream(fileName));
            //获取根节点bookstore
            Element rootElement = document.getRootElement();
            //获取根节点的子节点，返回子节点的数组
            List<Element> bookList = rootElement.getChildren();
            books = new ArrayList<Book>();
            for(Element bookElement : bookList){
                book = new Book();
                //获取bookElement的属性
                List<Attribute> bookAttributes = bookElement.getAttributes();
                for(Attribute attribute : bookAttributes){
                    if(attribute.getName().equals("id")){
                        String id = attribute.getValue(); //System.out.println(id);
                        book.setId(Integer.parseInt(id));
                    }
                }
                //获取bookElement的子节点
                List<Element> children = bookElement.getChildren();
                for(Element child : children){
                    if(child.getName().equals("name")){
                        String name = child.getValue();//System.out.println(name);
                        book.setName(name);
                    }else if(child.getName().equals("author")){
                        String author = child.getValue();
                        book.setAuthor(author);//System.out.println(author);
                    }else if(child.getName().equals("year")){
                        String year = child.getValue();
                        book.setYear(Integer.parseInt(year));
                    }else if(child.getName().equals("price")){
                        String price = child.getValue();
                        book.setPrice(Double.parseDouble(price));
                    }
                }
                books.add(book);
                book = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }


    public static void main(String[] args) {
        String fileName = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\books.xml";
        List<Book> books= new ReadXMLByJDom().getBooks(fileName);
        for(Book book : books){
            System.out.println(book);
        }
    }

}
