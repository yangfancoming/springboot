package com.goat.tiny.spring.beans.xml;


import com.goat.tiny.spring.beans.BeanDefinition;
import com.goat.tiny.spring.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class XmlBeanDefinitionReaderTest {


    /** 测试 xml 解析
     * 解析指定xml后 将xml中的内容 保存到 AbstractBeanDefinitionReader 类中的  private Map<String,BeanDefinition> registry; 中
     *  运行完后 断点查看 registry 对象就可以了
    */
	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		//  为啥这里 读取不到配置文件呢 ？ 为啥 E:\Code\Spring\GitHub3\tiny-spring-master 项目中的测试类就可以呢？
        //  因为：配置文件名写错了！ tiny.xml 一个是 tinyioc.xml  我草 ！
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}



}
