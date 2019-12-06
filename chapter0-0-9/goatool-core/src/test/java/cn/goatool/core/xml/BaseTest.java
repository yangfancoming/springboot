package cn.goatool.core.xml;

import cn.goatool.core.io.Resources;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:51
 */
public class BaseTest {

    public XNode common(String path,String expression) throws Exception{
        try (InputStream inputStream = Resources.getResourceAsStream(path)) {
            XPathParser xPathParser = new XPathParser(inputStream);
            XNode node = xPathParser.evalNode(expression);
            return node;
        }
    }
}
