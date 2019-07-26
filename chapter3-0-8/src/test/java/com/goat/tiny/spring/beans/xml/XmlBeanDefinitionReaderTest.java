package com.goat.tiny.spring.beans.xml;


import com.goat.tiny.spring.beans.BeanDefinition;
import com.goat.tiny.spring.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.Map;

public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		// doit  为啥这里 读取不到配置文件呢 ？ 为啥 E:\Code\Spring\GitHub3\tiny-spring-master 项目中的测试类就可以呢？
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}


    @Test
    public void test1(){
        URL resource = this.getClass().getClassLoader().getResource("tiny.xml");
        // file:/E:/Code/J2EE_code/MySpringBoot/springboot/chapter9-9-5/target/test-classes/tiny.xml
        System.out.println(resource);
    }
}
