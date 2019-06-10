package com.goat.shiro01.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        // 创建 ShiroFilterFactoryBean 并与 securityManager 进行关联
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(securityManager); // 必须设置 SecurityManager
        //拦截成功后的跳转页面： 如果不设置默认会自动寻找Web工程根目录下(templates/)的"/login.jsp"页面
		shiroBean.setLoginUrl("/login"); // 请求被拦截后  跳转到 登录页面  (哥是登录页哦) 没有登陆的用户只能访问登陆页面
		shiroBean.setSuccessUrl("/success");// 设置成功之后要跳转的链接
        shiroBean.setUnauthorizedUrl("/403"); //未授权界面; perms[hello:add] 验证失败后 要跳转的页面
//		shiroBean.setFilterChainDefinitionMap(filterMap);
        shiroBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());//  加载url拦截规则
		return shiroBean;
	}
    /**
     对于登录请求，Filter直接放过，进到controller里面。Controller会调用shiro做用户名和密码的校验，成功后返回token
     */
    @Bean
    protected ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition(); // 为了保证顺序 使用 LinkedHashMap
        chainDefinition.addPathDefinition("/", "anon"); //  对应 LoginController  中  index 首页的跳转  不拦截
        chainDefinition.addPathDefinition("/static/**", "anon");
        chainDefinition.addPathDefinition("/hello/test1", "anon"); //  对应 HelloController  中 /hello/test1   不拦截
        chainDefinition.addPathDefinition("/logout", "logout");   //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        chainDefinition.addPathDefinition("/doLogin", "noSessionCreation,anon");
        /**
         授权过滤器 如果 指定了未授权界面 那么 直接跳到指定的页面(403) 如果未指定未授权界面  那么直接报错 401 Unauthorized
         授权认证会调用 doGetAuthorizationInfo 函数
         * */
        chainDefinition.addPathDefinition("/hello/add", "perms[hello:add]");
        chainDefinition.addPathDefinition("/hello/edit", "perms[hello:edit]");
//        chainDefinition.addPathDefinition("/**", "authc");   // 过滤链定义，从上向下顺序执行，一般将 /** 放在最为下边  这是一个坑呢，一不小心代码就不好使了;
        chainDefinition.addPathDefinition("/**", "user"); // user表示配置记住我或认证通过可以访问的地址
        return chainDefinition;
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
        securityManager.setRememberMeManager(rememberMeManager());  // 3. 设置记住我功能
		return securityManager;
	}

	/**  用于  thymeleaf 和 shiro 标签配合使用 （为了在thymeleaf里使用shiro的标签的bean）  */
    @Bean
	public ShiroDialect getShiroDialect(){
	    return new ShiroDialect();
    }

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持; 加入注解的使用，不加入这个注解不生效
	 * @param securityManager
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

    /** cookie管理对象;记住我功能 */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /** cookie对象; */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    /**
     * FormAuthenticationFilter 过滤器 过滤记住我
     * @return
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        //对应前端的checkbox的name = rememberMe
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }


}