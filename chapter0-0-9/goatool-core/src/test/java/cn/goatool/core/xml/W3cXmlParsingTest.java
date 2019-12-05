package cn.goatool.core.xml;

import cn.goatool.core.io.Resources;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---20:34
 */
public class W3cXmlParsingTest {

    @Test
    public void parseAttributes() throws Exception {
        String xmlPath = "properties1.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            InputSource inputSource = new InputSource(inputStream);
            Document document = W3cXmlUtil.createDocument(inputSource);
            Node node = (Node) W3cXmlParsing.evaluate("/configuration/properties", document, XPathConstants.NODE);
            Properties properties = W3cXmlParsing.parseAttributes(node);
            Assert.assertEquals("{resource=dbconfig.properties}", properties.toString());
        }
    }


    @Test
    public void parseBody() throws IOException {
        String xmlPath = "cdata_demo.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            InputSource inputSource = new InputSource(inputStream);
            Document document = W3cXmlUtil.createDocument(inputSource);
            Node node = (Node) W3cXmlParsing.evaluate("/books/book/name", document, XPathConstants.NODE);
            String s = W3cXmlParsing.parseBody(node);
            System.out.println(s);
        }

    }
}
