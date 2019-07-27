package com.goat.tiny.spring.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 64274 on 2019/7/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/28---0:33
 */
public class IoTest {

    // 测试 IO 读取
    @Test
    public void test1(){
        URL resource = this.getClass().getClassLoader().getResource("tinyioc.xml");
        // file:/E:/Code/J2EE_code/MySpringBoot/springboot/chapter9-9-5/target/test-classes/tiny.xml
        System.out.println(resource);
    }

    // 测试 IO 读取
    @Test
    public void test2() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
