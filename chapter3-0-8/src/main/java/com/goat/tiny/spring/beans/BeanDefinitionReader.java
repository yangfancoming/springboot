package com.goat.tiny.spring.beans;

/**
 * 从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader {

   public abstract void loadBeanDefinitions(String location) throws Exception;
}
