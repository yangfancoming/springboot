package com.goat.chapter438;

import com.goat.chapter438.model.Books2;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/1.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/1---20:09
 */
public class DOMTest {

    public static void main(String[] args){

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-8\\src\\main\\resources\\books2.xml");
            //找到根节点
            Element root = document.getDocumentElement();

            System.out.println("------开始解析-------");
            NodeList booksList = root.getElementsByTagName("book");
            System.out.println("一共有" + booksList.getLength() + "本书");
            //遍历book节点的所有节点
            for (int i = 0; i < booksList.getLength(); i++){
                System.out.println("-----现在开始遍历第" +(i + 1) +  "本书的内容-----");
                //通过item(i)方法获取一个book节点
                Node nodeBook = booksList.item(i);
                //获取book节点的所有属性集合  <book category="CHILDREN" test = "123">
                NamedNodeMap attrs = nodeBook.getAttributes();
                System.out.println("第" + (i + 1) + "本书有"+ attrs.getLength() + "个属性");

                //遍历book属性
                for (int j = 0; j < attrs.getLength(); j++){
                    //通过item(index)方法获取book节点的某一个属性
                    Node attr = attrs.item(j);
                    //获取属性名和属性值
                    System.out.println("属性名：" + attr.getNodeName() + "， 属性值：" + attr.getNodeValue());
                }
                //解析book节点的子节点 title author year price
                NodeList bookchildNode = nodeBook.getChildNodes();
                //遍历bookchildNode获取每个节点的节点名和节点值
                System.out.println("第" + (i +1) + "本书共有" + bookchildNode.getLength() + "个子节点");

                for (int k = 0; k < bookchildNode.getLength(); k++){
                    short nodeType = bookchildNode.item(k).getNodeType();
                    System.out.println("第" + (k+1)+ "个节点的节点类型：" + nodeType);
                    //区分text类型的node和element类型的node
                    if (nodeType == Node.ELEMENT_NODE){
                        //获取element类型的节点
                        System.out.println("节点名：" + bookchildNode.item(k).getNodeName());
                        //获取element类型的节点值
                        System.out.println("--节点值是：" + bookchildNode.item(k).getTextContent());

                        if(bookchildNode.item(k).getNodeName().equals("title")){
                            Element nodeLang = (Element)  (bookchildNode.item(k));
                            String lang = nodeLang.getAttribute("lang");
                            System.out.println(lang);
                        }
                    }
                }
                System.out.println("-----结束遍历第" + (i+1)+"本书的内容------");
            }
            System.out.println("------解析完毕！------");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (ParserConfigurationException e){
            System.out.println(e.getMessage());
        }catch (SAXException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}