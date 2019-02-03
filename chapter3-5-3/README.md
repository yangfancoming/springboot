# 校验流程
    我们使用Shiro主要做3件事情：
    1）用户登录时做用户名密码校验；
    2）用户登录后收到请求时做JWT Token的校验；
    3）用户权限的校验
    
    
#登录认证流程
    登录controller
    从前面的ShiroFilterChainDefinition配置可以看出，对于登录请求，Filter直接放过，进到controller里面。Controller会调用shiro做用户名和密码的校验，成功后返回token。
    登录的Realm
    从上面的controller实现我们看到，controller只负责封装下参数，然后扔给Shiro了，这时候Shiro收到后，会到所有的realm中找能处理UsernamePasswordToken的Realm（我们这里是DbShiroRealm），然后交给Realm处理。Realm的实现一般直接继承AuthorizingRealm即可，只需要实现两个方法，doGetAuthenticationInfo()会在用户验证时被调用，我们看下实现。
