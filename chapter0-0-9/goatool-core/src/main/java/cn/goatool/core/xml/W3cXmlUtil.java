package cn.goatool.core.xml;

import cn.goatool.core.exception.BuilderException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---20:30
 */
public class W3cXmlUtil {



    /**
     *   调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂
     *   创建document时用到了两个类：DocumentBuilderFactory和DocumentBuilder。
     *   DocumentBuilderFactory.newInstance()创建DocumentBuilderFactory实现类的对象，它会通过一下方式来查找实现类：
     *       1.在系统环境变量中(System.getProperties())中查找 key=javax.xml.parsers.DocumentBuilderFactory
     *       2.如果1没有找到，则找java.home/lib/jaxp.properties 文件，如果文件存在，在文件中查找key=javax.xml.parsers.DocumentBuilderFactory
     *       3.如果2没有找到,则在classpath中的所有的jar包中查找META-INF/services /javax.xml.parsers.DocumentBuilderFactory 文件
     *   如果上面都没有找到，那么就使用JDK自带的实现类：com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
     *   在创建DocumentBuilder实例的时候，是根据DocumentBuilderFactoryImpl的不同有不同的实现。
    */
    public static Document createDocument(InputSource inputSource) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 指定由此代码生成的解析器将忽略注释。默认情况下，其值设置为 false。
            factory.setIgnoringComments(true);
            // 调用工厂对象的 newDocumentBuilder 方法得到 DOM 解析器对象。
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(inputSource);
        } catch (Exception e) {
            throw new BuilderException("Error creating document instance.  Cause: " + e, e);
        }
    }

}
