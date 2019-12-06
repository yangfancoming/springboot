package cn.goatool.core.xml;

import org.w3c.dom.CharacterData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class XNode {

    // 被XNode包装的当前节点
    private final Node node;
    // 当前节点名称
    private final String name;
    // 当前节点文本内容
    private final String body;
    // 当前节点所有属性
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
     * @Description: 获取 当前节点的所有子节点 并将这些子节点 两个属性和对应的属性值 保存到Properties对象
     * @param key1 每个子节点的属性名1
     * @param key2 每个子节点的属性名2
     *   <settings>
     *     <setting name="mapUnderscoreToCamelCase" value="true"/>
     *     <setting name="cacheEnabled" value="true" />
     *   </settings>
     * 输入示例：   getChildrenAsProperties("name", "value");
     * 输出结果：   key：mapUnderscoreToCamelCase  value：true
     * 输出结果：   key：cacheEnabled              value：false
     * @author goat
     * @date 2018/7/11
     * 注意： 如果当前节点没有子节点则返回的 Properties  size为0
     */
    public Properties getChildrenAsProperties(String key1,String key2) {
        Properties properties = new Properties();
        List<XNode> childrens = getChildren();
        for (XNode child : childrens) {
            // 获取 <property> 节点的 name 和 value 属性
            String key = child.getStringAttribute(key1);
            String value = child.getStringAttribute(key2);
            //只有当节点同时具有name和value属性才会添加到properties中
            if (key != null && value != null) {
                properties.setProperty(key, value);// 设置属性到属性对象中
            }
        }
        return properties;
    }

    public Properties getChildrenAsProperties() {
        return getChildrenAsProperties("name", "value");
    }

    public String getStringAttribute(String name) {
        return getStringAttribute(name, null);
    }

    public String getStringAttribute(String name, String def) {
        String value = attributes.getProperty(name);
        return (value == null) ? def : value;
    }


    /**
     * 获取当前节点的所有孩子节点(List集合)
     */
    public List<XNode> getChildren() {
        List<XNode> children = new ArrayList<>();
        //获取所有子节点
        NodeList nodeList = node.getChildNodes();
        if (nodeList != null) {
            for (int i = 0, n = nodeList.getLength(); i < n; i++) {
                Node node = nodeList.item(i);
                //如果子节点类型是元素节点，就添加到list中
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // 将节点对象封装到 XNode 中，并将 XNode 对象放入 children 列表中
                    children.add(new XNode(node));
                }
            }
        }
        return children;
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
