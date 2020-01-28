package com.goat;


import com.goat.utils.FreemarkerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
/**
 * @Description: 功能描述： freemarker 文件生成
 * @author: Goat
 * @Param:
 * @Return:
 * @Date:  2018年11月30日14:13:03
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {

    @Autowired
    private FreemarkerUtils freemarkerUtils; // sos 注意这里  必须通过注入使用

    @Test
    public void test1() throws Exception {
        Map map = new HashMap();
        map.put("hello","Role_add");
        freemarkerUtils.common(map,"hello.ftl","myOut.txt");
    }
}
