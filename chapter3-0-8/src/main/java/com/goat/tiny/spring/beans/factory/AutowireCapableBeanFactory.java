package com.goat.tiny.spring.beans.factory;

import com.goat.tiny.spring.BeanReference;
import com.goat.tiny.spring.beans.BeanDefinition;
import com.goat.tiny.spring.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 可自动装配内容的BeanFactory
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		if (bean instanceof BeanFactoryAware) {
			((BeanFactoryAware) bean).setBeanFactory(this);
		}
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}

			try {
			    // setText
                String methodName = "set" + propertyValue.getName().substring(0, 1).toUpperCase()+ propertyValue.getName().substring(1);
				Method declaredMethod = bean.getClass().getDeclaredMethod(methodName, value.getClass());
                // 设置权限  使其可以访问 类中的私有方法  否则 报权限错误
				declaredMethod.setAccessible(true);
				// 调用目标方法
				declaredMethod.invoke(bean, value);
			} catch (NoSuchMethodException e) {
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}
}
