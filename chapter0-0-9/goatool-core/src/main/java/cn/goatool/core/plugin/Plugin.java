
package cn.goatool.core.plugin;

import cn.goatool.core.exception.PluginException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 利用JDK动态代理和责任链设计模式的综合运用
*/
public class Plugin implements InvocationHandler {
  //被代理的目标类
  private final Object target;
  //对应的拦截器
  private final Interceptor interceptor;
  //拦截器拦截的方法
  private final Map<Class<?>, Set<Method>> signatureMap;

  private Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
    this.target = target;
    this.interceptor = interceptor;
    this.signatureMap = signatureMap;
  }

/**
 * 就以SqlCostPlugin为例，我的@Intercepts定义的是：
 * @Intercepts({
 * @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
 * @Signature(type = StatementHandler.class, method = "update", args = {Statement.class})
 * })
 *
 * 此时，生成的方法签名映射signatureMap应当是（我这里把Map给toString()了）：
 * {interface org.apache.ibatis.executor.statement.StatementHandler=[
 * public abstract int org.apache.ibatis.executor.statement.StatementHandler.update(java.sql.Statement) throws java.sql.SQLException,
 * public abstract java.util.List org.apache.ibatis.executor.statement.StatementHandler.query(java.sql.Statement,org.apache.ibatis.session.ResultHandler) throws java.sql.SQLException
 * ]}
 *
 * 一个Class对应一个Set，Class为StatementHandler.class，Set为StataementHandler中的两个方法
 *
 * 如果我new的是StatementHandler接口的实现类，那么可以为之生成代理，因为signatureMap中的key有StatementHandler这个接口
 * 如果我new的是Executor接口的实现类，那么直接会把Executor接口的实现类原样返回，因为signatureMap中的key并没有Executor这个接口
*/
  /**
   * @Description: 包装
   * @author fan.yang
   * @date 2019年10月27日21:11:26
   * @param target 要包装的目标对象
   * @param interceptor 指定要用哪个拦截器进行包装
   * @return 成功包装后的对象
   */
  public static Object wrap(Object target, Interceptor interceptor) {
    //从拦截器的注解中获取拦截的类名和方法信息  //取得签名Map
    Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
    // 取得要改变行为的类(ParameterHandler|ResultSetHandler|StatementHandler|Executor)
    // 取得要包装的目标对象的类型
    Class<?> type = target.getClass();
    // 取得要包装的目标对象的类型所有要实现的接口
    // 解析被拦截对象的所有接口（注意是接口）    //取得接口
    // 获取需要代理的对象的Class上声明的所有接口
    Class<?>[] interfaces = getAllInterfaces(type, signatureMap);
    //使用JDK内置的Proxy创建代理对象
    if (interfaces.length > 0) {
      return Proxy.newProxyInstance(type.getClassLoader(),interfaces,new Plugin(target, interceptor, signatureMap));
    }
    return target;
  }

  /**
   * @Description:
   * @author fan.yang
   * @date 2019年10月28日19:03:13
   * @param proxy 当前的代理对象
   * @param method 当前执行的方法
   * @param args 当前执行方法的参数
   * @return
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
      //看看如何拦截
      Set<Method> methods = signatureMap.get(method.getDeclaringClass());
      //看哪些方法需要拦截 //获取当前执行方法所属的类，并获取需要被拦截的方法集合
      if (methods != null && methods.contains(method)) {
        // 调用Interceptor.intercept，也即插入了我们自己的逻辑
        // 如果需被拦截的方法集合包含当前执行的方法，则执行拦截器的interceptor方法
        return interceptor.intercept(new Invocation(target, method, args));
      }
      //最后还是执行原来逻辑 // 如果不是，则直接调用目标方法的Invoke方法
      return method.invoke(target, args);
    } catch (Exception e) {
        throw new PluginException(e);
    }
  }

  //取得签名Map
  private static Map<Class<?>, Set<Method>> getSignatureMap(Interceptor interceptor) {
    //1.首先从Interceptor的实现类上获取Intercepts注解 //取Intercepts注解，例子可参见 ExamplePlugin.java
      Class<? extends Interceptor> aClass = interceptor.getClass();
      Intercepts interceptsAnnotation = aClass.getAnnotation(Intercepts.class);
    // issue #251  如果Interceptor的类上没有定义Intercepts注解，则抛出异常，说明我们在自定义插件时，必须要有Intercepts注解
    if (interceptsAnnotation == null) {
      throw new PluginException("No @Intercepts annotation was found in interceptor " + interceptor.getClass().getName());
    }
    //value是数组型，Signature的数组
    // 解析Interceptor的values属性（Signature[]）数组，然后存入HashMap<Class<?>, Set< Method>>容器内
    Signature[] sigs = interceptsAnnotation.value();
    //每个class里有多个Method需要被拦截,所以这么定义
    Map<Class<?>, Set<Method>> signatureMap = new HashMap<>();
    for (Signature sig : sigs) {
      Set<Method> methods = signatureMap.computeIfAbsent(sig.type(), k -> new HashSet<>());
      try {
        Method method = sig.type().getMethod(sig.method(), sig.args());
        methods.add(method);
      } catch (NoSuchMethodException e) {
        throw new PluginException("Could not find method on " + sig.type() + " named " + sig.method() + ". Cause: " + e, e);
      }
    }
    return signatureMap;
  }

  /**
   * 该方法的实现比较简单，并不是获取目标对象所实现的所有接口，而是返回需要拦截的方法所包括的接口
  */
  private static Class<?>[] getAllInterfaces(Class<?> type, Map<Class<?>, Set<Method>> signatureMap) {
    Set<Class<?>> interfaces = new HashSet<>();
    while (type != null) {
      for (Class<?> c : type.getInterfaces()) {
        //貌似只能拦截ParameterHandler|ResultSetHandler|StatementHandler|Executor
        //拦截其他的无效
        //当然我们可以覆盖Plugin.wrap方法，达到拦截其他类的功能
        if (signatureMap.containsKey(c)) {
          interfaces.add(c);
        }
      }
      type = type.getSuperclass();
    }
    return interfaces.toArray(new Class<?>[interfaces.size()]);
  }

}
