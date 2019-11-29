package com.goat.chapter439;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---13:28
 */
public class MyFilter extends XMLFilterImpl {

    private String currentElement;

    public MyFilter( XMLReader parent ) {
        super(parent);
    }
    /**
     * 过滤掉元素<技术书籍>的开始事件
     **/
    @Override
    public void startElement( String namespaceURI, String localName, String fullName, Attributes attributes ) throws SAXException {
        currentElement = localName;
        if ( !localName.equals("技术书籍") ) {
            super.startElement(namespaceURI, localName, fullName, attributes);
        }
    }
    /**
     * 过滤掉元素<技术书籍>的结束事件
     **/
    @Override
    public void endElement(String namespaceURI, String localName, String fullName) throws SAXException {
        if ( !localName.equals("技术书籍") ) {
            super.endElement(namespaceURI, localName, fullName);
        }
    }
    /**
     * 过滤掉元素<技术书籍>中的内容
     **/
    @Override
    public void characters(char[] buffer, int start, int length)  throws SAXException {
        if ( !currentElement.equals("技术书籍") ) {
            super.characters( buffer,start,length );
        }
    }
}
