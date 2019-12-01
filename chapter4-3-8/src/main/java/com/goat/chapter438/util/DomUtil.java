package com.goat.chapter438.util;

import com.goat.chapter438.model.Linkman;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/30---10:35
 */
public class DomUtil {


    public static List<Linkman> selectAll() {
        List<Linkman> list = new ArrayList<>();
        // Dom方法
        // 获取Document对象
        // 1.获取DocumentBuilderFactory对象
        DocumentBuilderFactory bbf = DocumentBuilderFactory.newInstance();
        // 2.使用DocumentBuilderFactory创建DocumentBuilder对象
        try {
            DocumentBuilder builder = bbf.newDocumentBuilder();
            // 3.使用DocumentBuilder解析一个xml路径，得到一个Document对象
            Document doc = builder.parse(new File("resource/linkman.xml"));
            // 获取根元素
            Element root = doc.getDocumentElement();
            // 获取所有的linkman
            NodeList linkmans = root.getElementsByTagName("linkman");
            for (int i = 0; i < linkmans.getLength(); i++) {
                // 遍历得到每一个linkman标签
                Element linkmanEl = (Element) linkmans.item(i);
                // 通过linkman标签 去获取name标签、address标签、email标签
                Element nameEl = (Element) linkmanEl.getElementsByTagName("name").item(0);
                Element addressEl = (Element) linkmanEl.getElementsByTagName("address").item(0);
                Element emailEl = (Element) linkmanEl.getElementsByTagName("email").item(0);
                // 获取name、address、email的值
                String name = nameEl.getTextContent();
                String address = addressEl.getTextContent();
                String email = emailEl.getTextContent();
                // 获取linkman标签的id属性
                String id = linkmanEl.getAttribute("id");

                // 创建Linkman对象
                Linkman linkman = new Linkman();
                linkman.setId(id);
                linkman.setName(name);
                linkman.setAddress(address);
                linkman.setEmail(email);
                // 将linkman对象添加到集合
                list.add(linkman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void update(Linkman linkman) {//id=5 name ="林青霞"
        try {
            // 获取工厂对象
            DocumentBuilderFactory bbf = DocumentBuilderFactory.newInstance();
            // 获取构建对象
            DocumentBuilder builder = bbf.newDocumentBuilder();
            // 解析路径得到文档对象
            Document doc = builder.parse(new File("resource/linkman.xml"));
            // 获取根元素
            Element root = doc.getDocumentElement();
            // 获取所有的Linkman元素
            NodeList nodeList = root.getElementsByTagName("linkman");
            for (int i = 0; i < nodeList.getLength(); i++) {
                // 获取linkman元素的id属性值,来判断
                Element linkmanEl = (Element) nodeList.item(i);
                String linkmanId = linkmanEl.getAttribute("id");
                if (linkmanId.equals(linkman.getId())) {
                    linkmanEl.getElementsByTagName("name").item(0).setTextContent(linkman.getName());
                    linkmanEl.getElementsByTagName("address").item(0).setTextContent(linkman.getAddress());
                    linkmanEl.getElementsByTagName("email").item(0).setTextContent(linkman.getEmail());
                    //同步
                    TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),new StreamResult("resource/linkman.xml"));
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void delete(String id) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        // 获取工厂对象
        DocumentBuilderFactory bbf = DocumentBuilderFactory.newInstance();
        // 获取构建对象
        DocumentBuilder builder = bbf.newDocumentBuilder();
        // 解析路径得到文档对象
        Document doc = builder.parse(new File("resource/linkman.xml"));
        // 获取根元素
        Element root = doc.getDocumentElement();
        // 获取所有的Linkman元素
        NodeList nodeList = root.getElementsByTagName("linkman");
        for (int i = 0; i < nodeList.getLength(); i++) {
            // 获取linkman元素的id属性值,来判断
            Element linkmanEl = (Element) nodeList.item(i);
            String linkmanId = linkmanEl.getAttribute("id");
            if (linkmanId.equals(id)) {
                // 删除
                root.removeChild(linkmanEl);
                // 同步
                TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),new StreamResult("resource/linkman.xml"));
                return;
            }
        }
    }

    public static Linkman selectOneById(String id,InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
            // 获取工厂对象
            DocumentBuilderFactory bbf = DocumentBuilderFactory.newInstance();
            // 获取构建对象
            DocumentBuilder builder = bbf.newDocumentBuilder();
            // 解析路径得到文档对象
            Document doc = builder.parse(inputStream); //  E:\linkman.xml (系统找不到指定的文件。)
            // 获取根元素
            Element root = doc.getDocumentElement();
            // 获取所有的Linkman元素
            NodeList nodeList = root.getElementsByTagName("linkman");
            for (int i = 0; i < nodeList.getLength(); i++) {
                // 获取linkman元素的id属性值,来判断
                Element linkmanEl = (Element) nodeList.item(i);
                String linkmanId = linkmanEl.getAttribute("id");
                if (linkmanId.equals(id)) {
                    // 如果等于参数id,就去获取对应的name、address、email
                    String name = linkmanEl.getElementsByTagName("name").item(0).getTextContent();
                    String address = linkmanEl.getElementsByTagName("address").item(0).getTextContent();
                    String email = linkmanEl.getElementsByTagName("email").item(0).getTextContent();
                    // 创建Linkman对象
                    Linkman linkman = new Linkman();
                    linkman.setId(id);
                    linkman.setName(name);
                    linkman.setAddress(address);
                    linkman.setEmail(email);
                    return linkman;
                }
            }
        return null;
    }


    public static void insert(Linkman linkman,InputStream inputStream) {
        try {
            // 获取工厂对象
            DocumentBuilderFactory bbf = DocumentBuilderFactory.newInstance();
            // 获取构建对象
            DocumentBuilder builder = bbf.newDocumentBuilder();
            // 解析路径得到文档对象
            Document doc = builder.parse(inputStream);
            // 获取根元素
            Element root = doc.getDocumentElement();
            // 创建linkman元素
            Element linkmanEl = doc.createElement("linkman");
            linkmanEl.setAttribute("id", linkman.getId());
            // 把linkman作为root的子节点
            root.appendChild(linkmanEl);
            // 创建name、address、email
            Element nameEl = doc.createElement("name");
            Element addressEl = doc.createElement("address");
            Element emailEl = doc.createElement("email");
            // 给他们赋值内容
            nameEl.setTextContent(linkman.getName());
            addressEl.setTextContent(linkman.getAddress());
            emailEl.setTextContent(linkman.getEmail());
            // 建立name、address、email和linkman标签的关系
            linkmanEl.appendChild(nameEl);
            linkmanEl.appendChild(addressEl);
            linkmanEl.appendChild(emailEl);
            // 同步 将内存中的xml树,写到文件中
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            OutputStream outputStream = new FileOutputStream("linkman.xml");
            transformer.transform(new DOMSource(doc), new StreamResult(outputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
