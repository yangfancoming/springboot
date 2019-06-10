# 增加 encache 缓存
    
    增加依赖
            <!-- 配置ehcache缓存 -->
            <dependency>
                <groupId>org.apache.shiro</groupId>
                <artifactId>shiro-ehcache</artifactId>
                <version>1.4.0</version>
            </dependency>
            
     shiroConfig 配置类中 增加 
             1.public SecurityManager securityManager(MyShiroRealm shiroRealm){ 方法中增加  
             securityManager.setCacheManager(ehCacheManager());
             shiroRealm.setCachingEnabled(true);
             shiroRealm.setAuthenticationCachingEnabled(true);  //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
             shiroRealm.setAuthenticationCacheName("authenticationCache");    //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
             shiroRealm.setAuthorizationCachingEnabled(true);  //启用授权缓存，即缓存AuthorizationInfo信息，默认false
             shiroRealm.setAuthorizationCacheName("authorizationCache"); //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
    
              2. 增加bean
                /**
                 * shiro缓存管理器;
                 * 需要添加到securityManager中
                 */
                @Bean
                public EhCacheManager ehCacheManager(){
                    EhCacheManager cacheManager = new EhCacheManager();
                    cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
                    return cacheManager;
                }
                
      controller 中 增加  
          //   http://localhost:8352/clear
          @RequestMapping("/clear")
          @ResponseBody
          public void clear(){
              //添加成功之后 清除缓存
              DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
              MyShiroRealm shiroRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
              shiroRealm.clearAllCache();//清除权限 相关的缓存
          }
                
    
    MyShiroRealm 中增加
    /**
         * 重写方法,清除当前用户的的 授权缓存
         * @param principals
         */
        @Override
        public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
            super.clearCachedAuthorizationInfo(principals);
        }
    
        /**
         * 重写方法，清除当前用户的 认证缓存
         * @param principals
         */
        @Override
        public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
            super.clearCachedAuthenticationInfo(principals);
        }
    
        @Override
        public void clearCache(PrincipalCollection principals) {
            super.clearCache(principals);
        }
    
        /**
         * 自定义方法：清除所有 授权缓存
         */
        public void clearAllCachedAuthorizationInfo() {
            getAuthorizationCache().clear();
        }
    
        /**
         * 自定义方法：清除所有 认证缓存
         */
        public void clearAllCachedAuthenticationInfo() {
            getAuthenticationCache().clear();
        }
    
        /**
         * 自定义方法：清除所有的  认证缓存  和 授权缓存
         */
        public void clearAllCache() {
            clearAllCachedAuthenticationInfo();
            clearAllCachedAuthorizationInfo();
        }
    
    }

    验证结果：
        登录成功后 返回请求： http://localhost:8352/success 
        控制台 只打印一次：  执行授权方法  User{id='1', name='null', age=null, username='admin', password='12345', code=null}
        若是没有缓存成功 则会 打印多次！！！
        执行  http://localhost:8352/clear  请求 清空缓存后  再次 http://localhost:8352/success  请求 查看控制台情况！！！
       
       