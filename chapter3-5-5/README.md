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