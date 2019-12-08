
package cn.goatool.core.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 拦截器执行时的上下文环境，其实就是目标方法的调用信息，
 * 包含目标对象、调用的方法信息、参数信息。
 * 其中包含一个非常重要的方法：proceed
 */
public class Invocation {
  //调用的对象
  private final Object target;
  //调用的方法
  private final Method method;
  //参数
  private final Object[] args;

  public Invocation(Object target, Method method, Object[] args) {
    this.target = target;
    this.method = method;
    this.args = args;
  }

  public Object getTarget() {
    return target;
  }

  public Method getMethod() {
    return method;
  }

  public Object[] getArgs() {
    return args;
  }

  //继续做下去 //该方法的主要目的就是进行处理链的传播，执行完拦截器的方法后，最终需要调用目标方法的invoke方法
  public Object proceed() throws InvocationTargetException, IllegalAccessException {
    return method.invoke(target, args);
  }

}
