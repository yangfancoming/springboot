package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import java.io.IOException;



public class AttributeTest extends MyBase {

    /**
     *  添加的是： goat="luck"
     */
    @Test
    public void test() throws IOException {
        boolean result = addAttribute(document, 1,"goat","luck");
        if (result){
            save();
        }
    }

    /**
     *   删除的是： goat="luck"
     */
    @Test
    public void deleteAttribute() throws IOException {
        boolean result = deleteAttribute(document, 1,"goat");
        if (result){
            save();
        }
    }

    /**
     *   修改的是： goat="luck"
     */
    @Test
    public void updateAttribute() throws IOException {
        boolean result = updateAttribute(document, 1,"goat","what");
        if (result){
            save();
        }
    }

    private static boolean deleteAttribute(Document document, int rollNumber, String attributeName) {
        String expression="/class/student[@rollnumber="+rollNumber+"]";
        Node node=document.selectSingleNode(expression);
        boolean result=false;
        if(node!=null){
            Element element=(Element)node;
            Attribute attr=element.attribute(attributeName);
            if(attr!=null){
                element.remove(attr);
                result=true;
            }
        }
        return result;
    }

    private static boolean addAttribute(Document document, int rollNumber, String attributeName, String attributeValue) {
        String expression="/class/student[@rollnumber="+rollNumber+"]";
        Node node=document.selectSingleNode(expression);
        boolean result=false;
        if(node!=null){
            Element element = (Element)node;
            element.addAttribute(attributeName,attributeValue);
            result = true;
        }
        return result;
    }


    private static boolean updateAttribute(Document document, int rollNumber, String attributeName, String attributeValue) {
        String expression="/class/student[@rollnumber="+rollNumber+"]";
        Node node=document.selectSingleNode(expression);
        boolean result=false;
        if(node!=null){
            Element element=(Element)node;
            Attribute attr=element.attribute(attributeName);
            if(attr!=null){
                element.addAttribute(attributeName,attributeValue);
                result=true;
            }
        }
        return result;
    }


}
