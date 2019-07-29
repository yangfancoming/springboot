package com.goat.tiny.spring.beans.factory;

import com.goat.tiny.spring.beans.BeanDefinition;
import com.goat.tiny.spring.beans.example.HelloWorldService;
import com.goat.tiny.spring.beans.io.ResourceLoader;
import com.goat.tiny.spring.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;


public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
       /**
        * 2.初始化BeanFactory并注册bean  就是把 XmlBeanDefinitionReader 的父类中的
        *  其实就是把 private Map<String,BeanDefinition> registry; 拷贝给 AbstractBeanFactory 中的 	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
       */
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

	@Test
	public void testPreInstantiate() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		// 2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

		// 4.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
