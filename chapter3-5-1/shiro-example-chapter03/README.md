
#  问题：
     报错： Session creation has been disabled for the current subject
     由于： 在controller中，通过 request.getSession(_) 获取会话 session ，该session到底来源servletRequest 还是由shiro管理并管理创建的会话，主要由 安全管理器 SecurityManager 和 SessionManager 会话管理器决定。
      request.getSession或者subject.getSession获取到session都会调用at org.apache.shiro.subject.support.DelegatingSubject.getSession()函数，这就导致了异常出现。
