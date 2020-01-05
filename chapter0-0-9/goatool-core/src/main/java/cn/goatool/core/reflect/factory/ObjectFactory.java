
package cn.goatool.core.reflect.factory;

import java.util.List;
import java.util.Properties;

/**
 * MyBatis uses an ObjectFactory to create all needed new Objects.
 *  Mybatis 使用ObjectFactory去创建需要的对象
 *  创建对象工厂类 (通过反射方式创建)
 */
public interface ObjectFactory {

  /**
   * Sets configuration properties. 设置配置信息
   * @param properties configuration properties
   */
  default void setProperties(Properties properties) {
    // NOP
  }

  /**
   * Creates a new object with default constructor. 通过默认构造函数创建指定类的对象
   * @param type Object type
   */
  <T> T create(Class<T> type);

  /**
   * Creates a new object with the specified constructor and params. 根据参数列表，从指定类型中选择合适的构造器创建对象
   * @param type Object type
   * @param constructorArgTypes Constructor argument types
   * @param constructorArgs Constructor argument values
   */
  <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

  /**
   * Returns true if this object can have a set of other objects.
   * It's main purpose is to support non-java.util.Collection objects like Scala collections.
   * 检测指定类型是否是集合类型 主要处理java.util.Collection及其子类
   * @param type Object type
   * @return whether it is a collection or not
   * @since 3.1.0
   */
  <T> boolean isCollection(Class<T> type);

}
