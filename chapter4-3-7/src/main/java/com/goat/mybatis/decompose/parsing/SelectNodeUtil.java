package com.goat.mybatis.decompose.parsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Administrator on 2019/12/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---14:56
 */
public class SelectNodeUtil {

    private static Logger log = LoggerFactory.getLogger(SelectNodeUtil.class);

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
