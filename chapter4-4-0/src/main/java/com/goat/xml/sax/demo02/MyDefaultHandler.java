package com.goat.xml.sax.demo02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---13:23
 *
 *
 * 首先在我们实现的MyContentHandler.java中，你会发现有很多方法实际上什么也没有做，
 * 但为了实现ContentHandler接口，不得不把它们写出来，这样很是麻烦。
 * SAX API已经考虑到这个问题，在它的org.xml.sax.helper包中为我们提供了一个方便实现各种处理器接口的帮助类DefaultHandler。
 * 这个类缺省实现了上面提到的4个处理器接口。这样我们只需继承这个类，然后覆盖我们想要实现的事件处理方法即可。
 * 下面我们来新建一个继承了DefaultHandler的MyDefaultHandler.java类，
 * 然后把在MyContentHandler.java和MyErrorHandler.java中实现的事件处理方法照搬到MyDefaultHandler.java类中，
 * 那些没有使用的方法就不必重复了。
 */
public class MyDefaultHandler extends DefaultHandler {
    
    private StringBuffer buf;

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
    public void startPrefixMapping( String prefix, String uri ) {
        System.out.println("\n前缀映射: " + prefix +" 开始!"+ "  它的URI是:"+uri);
    }

    @Override
    public void endPrefixMapping( String prefix ) {
        System.out.println("\n前缀映射: "+prefix+" 结束!");
    }

    @Override
    public void startElement( String namespaceURI, String localName, String fullName, Attributes attributes )   {
        System.out.println("\n元素: " + "["+fullName+"]" +" 开始解析!");
        // 打印出属性信息
        for ( int i = 0; i < attributes.getLength(); i++ ) {
            System.out.println("\t属性名称:" + attributes.getLocalName(i)+ " 属性值:" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement( String namespaceURI, String localName,String fullName )   {
        //打印出非空的元素内容并将StringBuffer清空
        String nullStr="";
        if (!buf.toString().trim().equals(nullStr)){
            System.out.println("\t内容是: " + buf.toString().trim());
        }
        buf.setLength(0);
        //打印元素解析结束信息
        System.out.println("元素: "+"["+fullName+"]"+" 解析结束!");
    }
    public void characters( char[] chars, int start, int length )  {
        //将元素内容累加到StringBuffer中
        buf.append(chars,start,length);
    }
    
    @Override
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }

    @Override
    public void error( SAXParseException exception ) {
        System.out.println("******* ERROR ******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }

    @Override
    public void fatalError( SAXParseException exception )  {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}