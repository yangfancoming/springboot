package cn.goatool.core.xml;

import cn.goatool.core.exception.BuilderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.io.Reader;

/**
 *  W3cXml 解析工具类
 * @ author  山羊来了
 * @ date 2019/12/5---20:30
 */
public class XPathParser {

    private static Logger log = LoggerFactory.getLogger(XPathParser.class);
    private final Document document; //Document对象通过createDocument方法得到
    private XPath xpath;  //XPath对象

    public XPathParser(InputStream inputStream) {
        this.xpath = XPathFactory.newInstance().newXPath();
        this.document = createDocument(new InputSource(inputStream));
    }

    public XPathParser(Reader reader) {
        this.xpath = XPathFactory.newInstance().newXPath();
        this.document = createDocument(new InputSource(reader));
    }

    /* mybatis中都是使用  返回单个节点*/
    public XNode evalNode(String expression) {
        log.debug(  "XPathParser 解析的标签名称为：" + expression);
        return evalNode(document, expression);
    }

    /* 返回单个节点*/
    public XNode evalNode(Object root, String expression) {
        Node node = (Node) evaluate(expression, root, XPathConstants.NODE);
        if (node == null) {
            return null;
        }
        return new XNode(node);
    }

    /**
     *   主要适用于当XPath表达式的结果有且只有一个节点
     * 如果XPath表达式返回了多个节点，却指定类型为XPathConstants.NODE，则evaluate()方法将按照文档顺序返回第一个节点。
     * 如果XPath表达式的结果为一个空集，却指定类型为XPathConstants.NODE，则evaluate( )方法将返回null
     * @param expression xpath 表达式
     * @param root 待解析的节点/元素
     * @param returnType 指定解析的节点类型
     * @return CRC16校验值
     * 输入示例： evaluate("/configuration/properties", document, XPathConstants.NODE)
     * 输出结果： Node 解析结果
     * 注意：returnType参数，虽然evaluate返回的数据类型是Object的，但是如果指定了错误的returnType，那么在进行类型转换时将会报类型转换异常
     */
    private Object evaluate(String expression, Object root, QName returnType) {
        try {
            return xpath.evaluate(expression, root, returnType);
        } catch (Exception e) {
            throw new BuilderException("Error evaluating XPath.  Cause: " + e, e);
        }
    }



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
    private Document createDocument(InputSource inputSource) {
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
