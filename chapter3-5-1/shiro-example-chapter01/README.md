#  总结：
    在使用shiro 两种设置 鉴权方式中
         1.  filterChainDefinitionMap.put("/userInfo/del", "perms[hello:add]");
         2. @RequiresPermissions("userInfo:del")
     
     输入url  http://localhost:9090/userInfo/del  请求后  
    第一种方式： 可以跳转到 自己设定的403 未授权页面
    第二种方式： 不会跳转到 自己设定的403 未授权页面  而是抛出401异常 
        org.apache.shiro.authz.AuthorizationException: Not authorized to invoke method: 
        public java.lang.String com.springboot.test.shiro.modules.login.UserController.del(org.springframework.ui.Model)
   
   
# 记住我 功能：
    启动项目后，第一次进入页面跳转到login登录页面，当登录成功后，关闭浏览器重新打开再输入地址后，不需要重新登录，直接跳转。
    
    1. shiroConfig 加入配置
      filterChainDefinitionMap.put("/**", "user"); // user表示配置记住我或认证通过可以访问的地址
       securityManager.setRememberMeManager(rememberMeManager());
       
           /**
            * cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
            */
           @Bean("rememberMeCookie")
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
            * cookie管理对象;记住我功能,rememberMe管理器
            */
           @Bean
           public CookieRememberMeManager rememberMeManager(){
               CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
               cookieRememberMeManager.setCookie(rememberMeCookie());
               //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
               cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
               return cookieRememberMeManager;
           }
       
           /**
            * FormAuthenticationFilter 过滤器 过滤记住我
            */
           @Bean
           public FormAuthenticationFilter formAuthenticationFilter(){
               FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
               //对应前端的checkbox的name = rememberMe
               formAuthenticationFilter.setRememberMeParam("rememberMe");
               return formAuthenticationFilter;
           }

    2. /login  controller 中  加入 
        更改为  UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password,rememberMe); 
        并在函数形参中加入 boolean rememberMe
        
    3. 登录页面 加入
           <input type="checkbox" name="rememberMe" />记住我<br/> 