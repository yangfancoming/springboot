package com.goat.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
 *
Subject  用户主题 把操作交给 SecurityManager
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

		//shiro内置拦截器.
		Map<String,String> filterMap = new LinkedHashMap<>();// 为了保证顺序 使用 LinkedHashMap
		// 配置不会被拦截的链接 顺序判断
		filterMap.put("/", "anon"); //  对应 LoginController  中  index 首页的跳转  不拦截
		filterMap.put("/static/**", "anon");
		filterMap.put("/test2", "anon"); //  对应 LoginController  中 test2   不拦截
        filterMap.put("/doLogin", "anon");
        /**
         授权过滤器 如果 指定了未授权界面 那么 直接跳到指定的页面(403) 如果未指定未授权界面  那么直接报错 401 Unauthorized
         授权认证会调用 doGetAuthorizationInfo 函数
         * */
		filterMap.put("/hello/add", "perms[hello:add]");
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterMap.put("/logout", "logout");
		// 过滤链定义，从上向下顺序执行，一般将/**放在最为下边  这是一个坑呢，一不小心代码就不好使了;
		filterMap.put("/**", "authc");

        // 创建 ShiroFilterFactoryBean 并与 securityManager 进行关联
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(securityManager);
        shiroBean.setUnauthorizedUrl("/403"); //未授权界面; perms[hello:add] 验证失败后 要跳转的页面
        //拦截成功后的跳转页面： 如果不设置默认会自动寻找Web工程根目录下(templates/)的"/login.jsp"页面
		shiroBean.setLoginUrl("/login"); // 请求被拦截后  跳转到 登录页面  (哥是登录页哦)
		shiroBean.setSuccessUrl("/success");// 登录成功后要跳转的链接
		shiroBean.setFilterChainDefinitionMap(filterMap);
		return shiroBean;
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

	@Bean // 将该方法返回值 放入spring容器环境 其在容器中的名称为 securityManager
	public SecurityManager securityManager(MyShiroRealm myShiroRealm){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager(); // 1. 创建 DefaultWebSecurityManager 对象
		securityManager.setRealm(myShiroRealm);  // 2.securityManager 关联 自定义realm
		return securityManager;
	}

	// 用于  thymeleaf 和 shiro 标签配合使用
    @Bean
	public ShiroDialect getShiroDialect(){
	    return new ShiroDialect();
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