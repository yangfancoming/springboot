package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by Administrator on 2019/12/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---20:45
 */
public class ResourcesTest {


    @Test
    public void getResourceAsReader() throws IOException {
        String xmlPath = "mybatis-config.xml";
        try (Reader reader = Resources.getResourceAsReader(xmlPath)) {
            Assert.assertNotNull(reader);
        }
    }


    @Test
    public void getResourceAsStream() throws IOException {
        String xmlPath = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            Assert.assertNotNull(inputStream);
        }
    }


}
