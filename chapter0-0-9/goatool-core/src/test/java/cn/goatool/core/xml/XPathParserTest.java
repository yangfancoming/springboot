package cn.goatool.core.xml;

import org.junit.Test;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---9:46
 */
public class XPathParserTest extends BaseTest {


    @Test
    public void getResourceAsStream() throws Exception{
        XNode node = common("properties2.xml", "/configuration/properties");
        System.out.println(node);
    }

    @Test
    public void getResourceAsReader() throws Exception{
        XNode node = common("cdata_demo.xml", "/books/book/url");
        System.out.println(node);
    }


}
