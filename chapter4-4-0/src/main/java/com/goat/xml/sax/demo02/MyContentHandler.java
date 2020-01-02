package com.goat.xml.sax.demo02;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---11:56
 */
public class MyContentHandler implements ContentHandler {


    private StringBuffer buf;

    @Override
    public void setDocumentLocator(org.xml.sax.Locator locator) {

    }

    @Override
    public void startDocument()  {
        buf=new StringBuffer();
        System.out.println("*******开始解析文档*******");
    }

    @Override
    public void endDocument()  {
        System.out.println("*******解析文档结束*******");
    }

    @Override
    public void processingInstruction( String target, String instruction ){

    }

    @Override
    public void startPrefixMapping( String prefix, String uri ) {
        System.out.println("\n前缀映射: " + prefix +" 开始!"+ "  它的URI是:" + uri);
    }

    @Override
    public void endPrefixMapping( String prefix ) {
        System.out.println("\n前缀映射: "+prefix+" 结束!");
    }

    @Override
    public void startElement( String namespaceURI, String localName, String fullName, Attributes attributes ) {
        System.out.println("\n 元素: " + "["+fullName+"]" +" 开始解析!");
        // 打印出属性信息
        for ( int i = 0; i < attributes.getLength(); i++ ) {
            System.out.println("\t属性名称:" + attributes.getLocalName(i) + " 属性值:" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement( String namespaceURI, String localName, String fullName ) {
        //打印出非空的元素内容并将StringBuffer清空
        String nullStr="";
        if (!buf.toString().trim().equals(nullStr)){
            System.out.println("\t内容是: " + buf.toString().trim());
        }
        buf.setLength(0);
        //打印元素解析结束信息
        System.out.println("元素: "+"["+fullName+"]"+" 解析结束!");
    }

    @Override
    public void characters( char[] chars, int start, int length )  {
        //将元素内容累加到StringBuffer中
        buf.append(chars,start,length);
    }

    @Override
    public void ignorableWhitespace( char[] chars, int start, int length )   {

    }

    @Override
    public void skippedEntity( String name )  {
    }
}
