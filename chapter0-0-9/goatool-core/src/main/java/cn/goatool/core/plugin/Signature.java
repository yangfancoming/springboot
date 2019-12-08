
package cn.goatool.core.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 签名
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Signature {
  //就是定义哪些类，方法，参数需要被拦截
  // 指定要拦截的四大对象中的哪个对象
  Class<?> type();

  // 指定拦截指定对象后的 哪个方法
  String method();

  // 指定拦截方法的参数列表 （为了再函数重载时也能正确拦截）
  Class<?>[] args();
}
