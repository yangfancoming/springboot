package cn.goatool.core.xml;

import cn.goatool.core.exception.BuilderException;
import com.sun.corba.se.spi.orb.PropertyParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.Properties;

/**
 *  W3cXml 解析工具类
 * @ author  山羊来了
 * @ date 2019/12/5---20:30
 */
public class W3cXmlParsing {

    public static XPath xpath = XPathFactory.newInstance().newXPath();


    /**
     *  获取当前节点的文本节点内容，
     * @param node 待解析的节点
     * @return
     */
    public static String parseBody(Node node) {
        String data = getBodyData(node);
//        //如果该节点不是文本节点或者CDATA节点，就取其子节点值
//        if (data == null) {
//            NodeList children = node.getChildNodes();
//            for (int i = 0; i < children.getLength(); i++) {
//                Node child = children.item(i);
//                data = getBodyData(child);
//                //只要一个节点为文本节点或者CDATA节点,就结束循环。因而此时的body值只是node的第一个文本节点的内容
//                if (data != null) {
//                    break;
//                }
//            }
//        }
        return data;
    }

    /**
     * 如果该节点是文本节点或者CDATA节点，就取节点的内容
     * @param child 待解析的子节点 (主节点没有文本内容)
     * 输入示例： 节点  <url><![CDATA[http://www.mingribook.com/bookinfo.php?id=227&sid=4]]></url>
     * 输出结果： 该节点的文本内容  http://www.mingribook.com/bookinfo.php?id=227&sid=4
     */
    public static String getBodyData(Node child) {
        if (child.getNodeType() == Node.CDATA_SECTION_NODE || child.getNodeType() == Node.TEXT_NODE) {
            String data = ((CharacterData) child).getData();
            return data;
        }
        return null;
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
    public static Object evaluate(String expression, Object root, QName returnType) {
        try {
            return xpath.evaluate(expression, root, returnType);
        } catch (Exception e) {
            throw new BuilderException("Error evaluating XPath.  Cause: " + e, e);
        }
    }


    /**
     * 获取当前节点的所有属性，就是你配置在这个节点中的属性，不是text内容(XNode并没有采用一种继承的策略，而是一种组合的关系，这样子最好了)
     * @param n 节点
     * @return 节点的属性内容
     */
    public static Properties parseAttributes(Node n) {
        /**
         * 获取Node之中的属性，然后是进行遍历属性获取内容
         */
        Properties attributes = new Properties();
//        NamedNodeMap attributeNodes = n.getAttributes();
//        if (attributeNodes != null) {
//            for (int i = 0; i < attributeNodes.getLength(); i++) {
//                Node attribute = attributeNodes.item(i);
//                attributes.put(attribute.getNodeName(), attribute.getNodeValue());
//            }
//        }
        return attributes;
    }


    private static Logger log = LoggerFactory.getLogger(W3cXmlParsing.class);

    // 递归遍历 xml
    public static void foreachNode(Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE){
            String nodeName = node.getNodeName();
            log.info("节点：<{}> " ,nodeName);
            NamedNodeMap attributes = node.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++){
                //通过item(index)方法获取book节点的某一个属性
                Node attr = attributes.item(j);
                //获取属性名和属性值
                log.info(" 属性：{}  = \"{}\" " ,attr.getNodeName(),attr.getNodeValue());
            }
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                foreachNode(item);
            }
        }
    }

}
