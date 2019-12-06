package cn.goatool.core.xml;

import cn.goatool.core.io.Resources;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:39
 */
public class XNodeTest extends BaseTest {

    @Test
    public void getChildren() throws Exception{
        XNode node = common("cdata_demo.xml", "/books/book");
        List<XNode> children = node.getChildren();
        System.out.println(children);
    }

    @Test
    public void getChildrenAsProperties() throws Exception{
        XNode node = common("cdata_demo.xml", "/books/book");
        Properties childrenAsProperties = node.getChildrenAsProperties("unit","mark");
        System.out.println(childrenAsProperties);
    }

    @Test
    public void getChildrenAsProperties1() throws Exception{
        XNode node = common("properties1.xml", "/configuration/properties");
        Properties childrenAsProperties = node.getChildrenAsProperties();
        System.out.println(childrenAsProperties);
    }

    @Test
    public void getChildrenAsProperties2() throws Exception{
        XNode node = common("properties2.xml", "/configuration/properties");
        Properties childrenAsProperties = node.getChildrenAsProperties();
        System.out.println(childrenAsProperties);
    }

    @Test
    public void getChildrenAsProperties3() throws Exception{
        XNode node = common("settings.xml", "/configuration/settings");
        Properties childrenAsProperties = node.getChildrenAsProperties();
        System.out.println(childrenAsProperties);
    }

    @Test
    public void getStringAttribute() throws Exception{
        XNode node = common("properties2.xml", "/configuration/properties");
        String resource = node.getStringAttribute("resource");
        Assert.assertEquals("dbconfig.properties", resource);

        Properties properties = node.getChildrenAsProperties();
        System.out.println(properties);
        properties = Resources.getResourceAsProperties("dbconfig.properties");
        System.out.println(properties);
    }
}
