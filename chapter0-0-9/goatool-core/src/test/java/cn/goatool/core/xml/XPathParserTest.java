package cn.goatool.core.xml;

import cn.goatool.core.io.Resources;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---9:46
 */
public class XPathParserTest {

    @Test
    public void getResourceAsStream() throws Exception{
        String xmlPath = "properties1.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            XPathParser xPathParser = new XPathParser(inputStream);
            XNode node = xPathParser.evalNode("/configuration/properties");
            System.out.println(node);
        }
    }

    @Test
    public void getResourceAsReader() throws Exception{
        String xmlPath = "cdata_demo.xml";
        try (Reader reader = Resources.getResourceAsReader(xmlPath)) {
            XPathParser xPathParser = new XPathParser(reader);
            XNode node = xPathParser.evalNode("/books/book/url");
            System.out.println(node);
        }
    }
}
