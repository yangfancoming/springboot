#Spring Security 

    在开始集成之前，我们先简单了解几个接口：
    AuthenticationProvider
    AuthenticationProvider接口是用于认证的，可以通过实现这个接口来定制我们自己的认证逻辑，它的实现类有很多，默认的是JaasAuthenticationProvider
    
    AccessDecisionManager
    AccessDecisionManager是用于访问控制的，它决定用户是否可以访问某个资源，实现这个接口可以定制我们自己的授权逻辑。
    
    AccessDecisionVoter
    AccessDecisionVoter是投票器，在授权的时通过投票的方式来决定用户是否可以访问，这里涉及到投票规则。
    
    UserDetailsService
    UserDetailsService是用于加载特定用户信息的，它只有一个接口通过指定的用户名去查询用户。
    
    UserDetails
    UserDetails代表用户信息，即主体，相当于Shiro中的Subject。User是它的一个实现。
    
# 注意点：
    1. 注意：自定义的登陆页 login.html 需要username和password输入域！否则会一直认证失败！！！！
                    <input type="text" id="username" name="username" /> <br />
                    <input type="password" id="password" name="password" /> <br />
    2. 注意：MySecurityConfig 类中的loginPage() 与自定义登陆页 login.html 的 action 访问路径必须是一样的 toLogin  才能被SpringSecurity 拦截进行后续处理
                 http.formLogin().loginPage("/myLogin");
                <form th:action="@{/myLogin}" method="post">
    3. 注意：MySecurityConfig 类中的 loginPage("/myLogin") 是 浏览器url输入 为拦截地址时 会自动跳转到  http://localhost:8355/myLogin 请求
    4. 注意：MySecurityConfig 类中的 loginPage("/myLogin") 中的 /myLogin 请求必须是不能拦截的 必须要被放行 ！  .antMatchers("/myLogin").permitAll()
                否则  302 提示 多次重定向 错误
    
              
        