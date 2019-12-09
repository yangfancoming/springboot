package cn.goatool.core.xml;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:39
 */
public class MapperSelectTest extends BaseTest {

    @Test
    public void getChildren() throws Exception{
        XNode node = common("mybatis-config.xml", "/configuration/mappers");
        List<XNode> children = node.getChildren();
        for(XNode xNode:children){
            String resource = xNode.getStringAttribute("resource");
            System.out.println(resource);
        }

    }


}
