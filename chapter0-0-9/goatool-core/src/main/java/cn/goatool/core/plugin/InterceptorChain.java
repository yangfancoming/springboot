
package cn.goatool.core.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 拦截器链
 *
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 */
public class InterceptorChain {

  // 表示拦截器链中所有的拦截器
  private final List<Interceptor> interceptors = new ArrayList<>();

  /**
   * @Description: 包装
   * @author fan.yang
   * @date 2019年10月27日21:11:26
   * @param target 目标对象，需要被代理的对象
   *               这个是Executor、ParameterHandler、ResultSetHandler、StatementHandler接口的实现类，
   *               换句话说，plugin方法是要为Executor、ParameterHandler、ResultSetHandler、StatementHandler的实现类生成代理，
   *               从而在调用这几个类的方法的时候，其实调用的是InvocationHandler的invoke方法
   *
   *               这里的target是通过for循环不断赋值的，也就是说如果有多个拦截器，那么如果我用P表示代理，
   *               生成第一次代理为P(target)，生成第二次代理为P(P(target))，生成第三次代理为P(P(P(target)))，不断嵌套下去，这就得到一个重要的结论：
   *               <plugins>...</plugins>中后定义的<plugin>实际其拦截器方法先被执行，因为根据这段代码来看，
   *               后定义的<plugin>代理实际后生成，包装了先生成的代理，自然其代理方法也先执行
   * @return 成功包装后的对象
   */
  public Object pluginAll(Object target) {
    //遍历InterceptorChain的拦截器链，分别调用Intercpetor对象的Plugin进行拦截
    for (Interceptor interceptor : interceptors) {
      target = interceptor.plugin(target);
    }
    return target;
  }

  //增加拦截器链
  public void addInterceptor(Interceptor interceptor) {
    interceptors.add(interceptor);
  }

  //获取拦截器链
  public List<Interceptor> getInterceptors() {
    return Collections.unmodifiableList(interceptors);
  }

}
