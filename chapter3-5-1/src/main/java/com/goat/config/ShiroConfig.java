package com.goat.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
 *
Subject  用户主题 把操作交给 SecurityManager
SecurityManager  安全管理器  关联Realm
Realm  Shiro 连接数据的桥梁

ShiroFilterFactoryBean 关联 securityManager 关联 自定义realm

anon  ： 无需认证就可以访问
authc ： 必须认证后 才能访问
user  ：  如果使用 rememberMe的功能 可以直接访问
perms ： 该资源必须得到资源权限才可以访问
role  ： 该资源必须得到角色权限才可以访问
     * @Date:   2018/11/7
*/
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();// 为了保证顺序 使用 LinkedHashMap
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/", "anon"); //  对应 LoginController  中  index 首页的跳转  不拦截
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/test2", "anon"); //  对应 LoginController  中 test2   不拦截
        filterChainDefinitionMap.put("/doLogin", "anon");


        /**
         授权过滤器 如果 指定了未授权界面 那么 直接跳到指定的页面(403) 如果未指定未授权界面  那么直接报错 401 Unauthorized
         授权认证会调用 doGetAuthorizationInfo 函数
         * */
		filterChainDefinitionMap.put("/hello/add", "perms[hello:add]");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); //未授权界面;

		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		filterChainDefinitionMap.put("/**", "authc");
		//拦截成功后的跳转页面： 如果不设置默认会自动寻找Web工程根目录下(templates/)的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
//		shiroFilterFactoryBean.setSuccessUrl("/success");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}


	@Bean // 将该方法返回值 放入spring容器环境
	public SecurityManager securityManager(){
	    // 1. 创建 DefaultWebSecurityManager 对象
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        myShiroRealm.setCredentialsMatcher(new HashedCredentialsMatcher());
        // 3.securityManager 关联 自定义realm
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}

//	/**
//	 *  开启shiro aop注解支持.
//	 *  使用代理方式;所以需要开启代码支持;
//	 * @param securityManager
//	 * @return
//	 */
//	@Bean
//	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
//		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//		return authorizationAttributeSourceAdvisor;
//	}
//
//	@Bean(name="simpleMappingExceptionResolver")
//	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
//		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
//		Properties mappings = new Properties();
//		mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
//		mappings.setProperty("UnauthorizedException","403");
//		r.setExceptionMappings(mappings);  // None by default
//		r.setDefaultErrorView("error");    // No default
//		r.setExceptionAttribute("ex");     // Default is "exception"
//		//r.setWarnLogCategory("example.MvcLogger");     // No default
//		return r;
//	}
}