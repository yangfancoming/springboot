
package cn.goatool.core.plugin;

import java.util.Properties;

/**
 * 拦截器接口，用户自定义的拦截器需要实现该接口
*/
public interface Interceptor {

  //拦截 // 这个方法是拦截器的业务方法 就是实现要增强的功能；
  Object intercept(Invocation invocation) throws Throwable;

  //插入 // 这个方法是对拦截器的包装， 如果不包装的话它是不会被加入到拦截器链中 其实就是生成代理对象；
  /**
   * @Description: 包装
   * @author fan.yang
   * @date 2019年10月27日21:11:26
   * @param target 目标对象，需要被代理的对象
   * @return 成功包装后的对象
   */
  default Object plugin(Object target) {
      // this 为当前接口的实现类
    return Plugin.wrap(target, this);
  }

  //设置属性 //设置plugin配置的属性
  default void setProperties(Properties properties) {
    // NOP
      System.out.println("setProperties.....插件配置的信息  执行");
  }

}
