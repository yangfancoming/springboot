package cn.goatool.core.plugin;


/**
 * 完成插件签名：告诉MyBatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts(
		{
			@Signature(type= PluginDemo.class,method="fly",args=String.class)
		})
public class MyMybatisPlugin implements Interceptor {

	/**
	 * intercept：拦截：拦截目标对象的目标方法的执行
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("MyFirstPlugin...intercept:"+invocation.getMethod());
		//动态的改变一下sql运行的参数：以前1号员工，实际从数据库查询3号员工
		System.out.println("当前拦截到的对象：" + invocation.getTarget());
		//执行目标方法
		Object proceed = invocation.proceed();
		//返回执行后的返回值
		return proceed;
	}
}
