
#  问题：
     报错： Session creation has been disabled for the current subject
     由于： 在controller中，通过 request.getSession(_) 获取会话 session ，该session到底来源servletRequest 还是由shiro管理并管理创建的会话，主要由 安全管理器 SecurityManager 和 SessionManager 会话管理器决定。
      request.getSession或者subject.getSession获取到session都会调用at org.apache.shiro.subject.support.DelegatingSubject.getSession()函数，这就导致了异常出现。


    在Shiro中我们可以通过org.apache.shiro.session.mgt.eis.SessionDAO对象的getActiveSessions()方法方便的获取到当前所有有效的Session对象。
    通过这些Session对象，我们可以实现一些比较有趣的功能，比如查看当前系统的在线人数，查看这些在线用户的一些基本信息，强制让某个用户下线等。
    为了达到这几个目标，我们在现有的Spring Boot Shiro项目基础上进行一些改造（缓存使用Ehcache）。
    
    1.更改ShiroConfig
      为了能够在Spring Boot中使用SessionDao，我们在ShiroConfig中配置该Bean：
      @Bean
      public SessionDAO sessionDAO() {
          MemorySessionDAO sessionDAO = new MemorySessionDAO();
          return sessionDAO;
      }
      如果使用的是Redis作为缓存实现，那么SessionDAO则为RedisSessionDAO：
      @Bean
      public RedisSessionDAO sessionDAO() {
          RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
          redisSessionDAO.setRedisManager(redisManager());
          return redisSessionDAO;
      }
      
      2.在Shiro中，SessionDao通过org.apache.shiro.session.mgt.SessionManager进行管理，所以继续在ShiroConfig中配置SessionManager：

        @Bean
        public SessionManager sessionManager() {
            DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
            Collection<SessionListener> listeners = new ArrayList<SessionListener>();
            listeners.add(new ShiroSessionListener());
            sessionManager.setSessionListeners(listeners);
            sessionManager.setSessionDAO(sessionDAO());
            return sessionManager;
        }
    3.定义完SessionManager后，还需将其注入到SecurityManager中：

      @Bean  
      public SecurityManager securityManager(){  
          DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
          securityManager.setRealm(shiroRealm());
          ...
          securityManager.setSessionManager(sessionManager());
          return securityManager;  
      }
          
      4.通过SessionDao的getActiveSessions()方法，我们可以获取所有有效的Session，通过该Session，我们还可以获取到当前用户的Principal信息。
        
        值得说明的是，当某个用户被踢出后（Session Time置为0），该Session并不会立刻从ActiveSessions中剔除，所以我们可以通过其timeout信息来判断该用户在线与否。
        
        如果使用的Redis作为缓存实现，那么，forceLogout()方法需要稍作修改：

        @Override
        public boolean forceLogout(String sessionId) {
            Session session = sessionDAO.readSession(sessionId);
            sessionDAO.delete(session);
            return true;
        }