package cn.goatool.core.xml;

import cn.goatool.core.io.Resources;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---20:54
 */
public class W3cXmlUtilTest {


    @Test
    public void test() throws Exception {

        String xmlPath = "properties1.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            InputSource inputSource = new InputSource(inputStream);
            Document document = W3cXmlUtil.createDocument(inputSource);
            Node node = (Node) W3cXmlUtil.evaluate("/configuration/properties", document, XPathConstants.NODE);
            Properties properties = W3cXmlParsing.parseAttributes(node);
            System.out.println(properties);
        }
    }
}
