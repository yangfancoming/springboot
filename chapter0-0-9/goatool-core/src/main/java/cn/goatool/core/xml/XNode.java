package cn.goatool.core.xml;

import org.w3c.dom.CharacterData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Properties;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---8:42
 */
public class XNode {

    private final Node node;
    private final String name;
    private final String body;
    private final Properties attributes;

    public XNode( Node node) {
        this.node = node;
        this.name = node.getNodeName();
        //获取当前节点的所有属性
        this.attributes = parseAttributes(node);
        //获取当前节点的文本节点内容，当然获取到的数据是已经经过TokenHandler处理过的
        this.body = parseBody(node);
    }


    /**
     * 获取当前节点的所有属性，就是你配置在这个节点中的属性，不是text内容(XNode并没有采用一种继承的策略，而是一种组合的关系，这样子最好了)
     * @param n 节点
     * @return 节点的属性内容
     */
    private Properties parseAttributes(Node n) {
        /**
         * 获取Node之中的属性，然后是进行遍历属性获取内容
         */
        Properties attributes = new Properties();
        NamedNodeMap attributeNodes = n.getAttributes();
        if (attributeNodes != null) {
            for (int i = 0; i < attributeNodes.getLength(); i++) {
                Node attribute = attributeNodes.item(i);
                attributes.put(attribute.getNodeName(), attribute.getNodeValue());
            }
        }
        return attributes;
    }


    /**
     *  获取当前节点的文本节点内容，
     * @param node 待解析的节点
     * @return
     */
    private String parseBody(Node node) {
        String data = getBodyData(node);
        //如果该节点不是文本节点或者CDATA节点，就取其子节点值
        if (data == null) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                data = getBodyData(child);
                //只要一个节点为文本节点或者CDATA节点,就结束循环。因而此时的body值只是node的第一个文本节点的内容
                if (data != null) {
                    break;
                }
            }
        }
        return data;
    }


    /**
     * 如果该节点是文本节点或者CDATA节点，就取节点的内容
     * @param child 待解析的子节点 (主节点没有文本内容)
     * 输入示例： 节点  <url><![CDATA[http://www.mingribook.com/bookinfo.php?id=227&sid=4]]></url>
     * 输出结果： 该节点的文本内容  http://www.mingribook.com/bookinfo.php?id=227&sid=4
     */
    private String getBodyData(Node child) {
        if (child.getNodeType() == Node.CDATA_SECTION_NODE || child.getNodeType() == Node.TEXT_NODE) {
            String data = ((CharacterData) child).getData();
            return data;
        }
        return null;
    }

}
