
package cn.goatool.core.io;

import java.io.InputStream;
import java.net.URL;

/**
 * A class to wrap access to multiple class loaders making them work as one
 */
public class ClassLoaderWrapper {

  ClassLoader defaultClassLoader;
  ClassLoader systemClassLoader;

  ClassLoaderWrapper() {
    try {
      systemClassLoader = ClassLoader.getSystemClassLoader();
    } catch (SecurityException ignored) {
      // AccessControlException on Google App Engine
    }
  }

  /**
   * Get a resource as a URL using the current class path
   * @param resource - the resource to locate
   * @return the resource or null
   */
  public URL getResourceAsURL(String resource) {
    return getResourceAsURL(resource, getClassLoaders(null));
  }

  /**
   * Get a resource from the classpath, starting with a specific class loader
   * @param resource    - the resource to find
   * @param classLoader - the first classloader to try
   * @return the stream or null
   */
  public URL getResourceAsURL(String resource, ClassLoader classLoader) {
    return getResourceAsURL(resource, getClassLoaders(classLoader));
  }

  /**
   * Get a resource from the classpath
   * @param resource - the resource to find
   * @return the stream or null
   */
  public InputStream getResourceAsStream(String resource) {
    return getResourceAsStream(resource, getClassLoaders(null));
  }

  /**
   * Get a resource from the classpath, starting with a specific class loader
   * @param resource    - the resource to find
   * @param classLoader - the first class loader to try
   * @return the stream or null
   */
  public InputStream getResourceAsStream(String resource, ClassLoader classLoader) {
    return getResourceAsStream(resource, getClassLoaders(classLoader));
  }

  /**
   * Find a class on the classpath (or die trying)
   * @param name - the class to look for
   * @return - the class
   * @throws ClassNotFoundException Duh.
   */
  public Class<?> classForName(String name) throws ClassNotFoundException {
    return classForName(name, getClassLoaders(null));
  }

  /**
   * Find a class on the classpath, starting with a specific classloader (or die trying)
   * @param name        - the class to look for
   * @param classLoader - the first classloader to try
   * @return - the class
   * @throws ClassNotFoundException Duh.
   */
  public Class<?> classForName(String name, ClassLoader classLoader) throws ClassNotFoundException {
    return classForName(name, getClassLoaders(classLoader));
  }

  /**
   * Try to get a resource from a group of classloaders
   * @param resource    - the resource to get
   * @param classLoader - the classloaders to examine
   * @return the resource or null
   */
  InputStream getResourceAsStream(String resource, ClassLoader[] classLoader) {
    //循环ClassLoader 数组
    for (ClassLoader cl : classLoader) {
      if (null != cl) {
        // try to find the resource as passed  // 根据入参resource，读取该路径下文件
        InputStream returnValue = cl.getResourceAsStream(resource);
        // now, some class loaders want this leading "/", so we'll add it and try again if we didn't find the resource
        // 如果没有，加上“/”再尝试读取
        if (null == returnValue) {
          returnValue = cl.getResourceAsStream("/" + resource);
        }
        //如果读取到，终止循环，返回结果
        if (null != returnValue) {
          return returnValue;
        }
      }
    }
    return null;
  }

  /**
   * Get a resource as a URL using the current class path
   * @param resource    - the resource to locate
   * @param classLoader - the class loaders to examine
   * @return the resource or null
   */
  URL getResourceAsURL(String resource, ClassLoader[] classLoader) {
    URL url;
    //循环ClassLoader，通过指定或者默认的ClassLoader读取文件
    for (ClassLoader cl : classLoader) {
      if (null != cl) {
        // look for the resource as passed in...
        url = cl.getResource(resource);
        // ...but some class loaders want this leading "/", so we'll add it and try again if we didn't find the resource
        // 如果在resource的路径下没有找到，加“/”再进行查询读取
        if (null == url) {
          url = cl.getResource("/" + resource);
        }
        // "It's always in the last place I look for it!"  ... because only an idiot would keep looking for it after finding it, so stop looking already.
        // 如果查询到url，终止循环返回结果
        if (null != url) {
          return url;
        }
      }
    }
    // didn't find it anywhere.
    return null;
  }

  /**
   * Attempt to load a class from a group of classloaders
   * @param name        - the class to load
   * @param classLoader - the group of classloaders to examine
   * @return the class
   * @throws ClassNotFoundException - Remember the wisdom of Judge Smails: Well, the world needs ditch diggers, too.
   */
  Class<?> classForName(String name, ClassLoader[] classLoader) throws ClassNotFoundException {
    for (ClassLoader cl : classLoader) {
      if (null != cl) {
        try {
          Class<?> c = Class.forName(name, true, cl);
          if (null != c) {
            return c;
          }
        } catch (ClassNotFoundException e) {
          // we'll ignore this until all classloaders fail to locate the class
        }
      }
    }
    throw new ClassNotFoundException("Cannot find class: " + name);
  }

  // 构造一个classLoader数组
  ClassLoader[] getClassLoaders(ClassLoader classLoader) {
    return new ClassLoader[]{
      classLoader,  //参数指定的类加载器
      defaultClassLoader, // 系统指定的默认加载器
      Thread.currentThread().getContextClassLoader(),//当前线程绑定的类加载器
      getClass().getClassLoader(), // 当前类使用的类加载器
      systemClassLoader // System ClassLoader(App ClassLoader)
    };
  }

}
