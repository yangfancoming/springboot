package com.goat.xml.dom4j;

import com.goat.xml.base.MyBase;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import java.io.IOException;


public class PropertyTest extends MyBase {

    /**
     *  添加的是：  <goat1>luck1</goat1>
    */
    @Test
    public void addProperty() throws IOException {
        boolean result = addProperty(document, 1,"goat1","luck1");
        if (result){
            save();
        }
    }

    /**
     *  删除的是：  <goat1>luck1</goat1>
     */
    @Test
    public void deleteProperty() throws IOException {
        boolean result = deleteProperty(document, 1,"goat1");
        if (result){
            save();
        }
    }

    /**
     *  修改的是：  <goat1>luck1</goat1>
     */
    @Test
    public void updateProperty() throws IOException {
        boolean result = updateProperty(document, 1,"goat1","what");
        if (result){
            save();
        }
    }


    private static boolean addProperty(Document document, int rollNumber,String propertyName, String propertyValue) {
        String expression="/class/student[@rollnumber="+rollNumber+"]";
        Node node=document.selectSingleNode(expression);
        boolean result=false;
        if(node!=null) {
            Element element=(Element)node;
            element.addElement(propertyName).addText(propertyValue);
            result=true;
        }
        return result;
    }


    private static boolean deleteProperty(Document document, int rollNumber,String propertyName) {
        String expression1="/class/student[@rollnumber="+rollNumber+"]/"+propertyName;
        Node node1=document.selectSingleNode(expression1);
        String expression2="/class/student[@rollnumber="+rollNumber+"]";
        Node node2=document.selectSingleNode(expression2);
        boolean result=false;
        if(node1!=null)
        {
            Element element1=(Element)node1;
            Element element2=(Element)node2;
            element2.remove(element1);
            result=true;
        }
        return result;
    }

    private static boolean updateProperty(Document document, int rollNumber,String propertyName, String propertyValue) {

        String expression="/class/student[@rollnumber="+rollNumber+"]/"+propertyName;
        Node node=document.selectSingleNode(expression);
        boolean result=false;
        if(node!=null)
        {
            Element element=(Element)node;
            element.setText(propertyValue);
            result=true;
        }
        return result;
    }

}
