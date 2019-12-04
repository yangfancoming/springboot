package com.goat.mybatis.decompose;

import cn.goatool.core.io.Resources;
import com.goat.mybatis.decompose.parsing.SelectNodeUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.Reader;

/**
 * Created by Administrator on 2019/12/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---13:58
 */
public class App {

    private Logger log = LoggerFactory.getLogger(getClass());

    XPathParser xPathParser = new XPathParser();

    XPath xpath = XPathFactory.newInstance().newXPath();

    @Test
    public void test() throws Exception {
        String xmlPath = "mybatis-config.xml";
        try (Reader reader = Resources.getResourceAsReader(xmlPath)) {
            Document document = xPathParser.createDocument(new InputSource(reader));
            Node node = (Node) xpath.evaluate("/configuration", document, XPathConstants.NODE);
            SelectNodeUtil.foreachNode(node);
        }
    }


}
