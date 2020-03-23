package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Administrator on 2019/12/4.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---20:45
 */
public class ResourcesTest {

    private Logger log = LoggerFactory.getLogger(getClass());
    String xmlPath = "mybatis-config.xml";

    @Test
    public void getResourceAsReader() throws IOException {
        try (Reader reader = Resources.getResourceAsReader(xmlPath)) {
            Assert.assertNotNull(reader);
        }
    }

    @Test
    public void getResourceAsStream() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            Assert.assertNotNull(inputStream);
        }
    }

    @Test
    public void getResourceAsProperties() throws IOException {
        Properties properties = Resources.getResourceAsProperties("dbconfig.properties");
        assertEquals("{jdbc.url=jdbc:hsqldb:mem:cache, jdbc.username=sa, jdbc.driver=org.hsqldb.jdbcDriver, jdbc.password=}", properties.toString());
    }

    @Test
    public void classForName() throws Exception {
        Class<?> clazz = Resources.classForName("cn.goatool.core.reflect.Student");
        log.info("Resources.classForName {}" ,clazz);
        log.info("Resources.classForName getSimpleName {}" ,clazz.getSimpleName());

        Method[] declaredMethods = clazz.getDeclaredMethods();
        log.info("declaredMethods {}" ,declaredMethods);
        for (Method method: declaredMethods){
            if (!method.getName().equals("getTitle")) continue;
            method.invoke(clazz.newInstance()); // 执行 Student类中的getTitle()成员方法
            break;
        }
    }


}
