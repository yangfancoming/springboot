package com.goat.chapter439;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/29---13:16
 */
public class MyErrorHandler implements ErrorHandler {
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误111信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void error( SAXParseException exception )  {
        System.out.println("******* ERROR ******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误222信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void fatalError( SAXParseException exception )  {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误333信息:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}