#Spring Security 结合 jwt
我们之前介绍过,Spring security是基于过滤器(Filter)的,使用过滤器我们可以很容易的拦截某些请求. 
因此通过上面对jwt的了解,我们就可以在过滤器中处理token的生成和校验.

    大致流程如下:
    1.当用户进行提交登陆表单时,自定义一个拦截器JWTLoginFilter进行表单参数的获取.
    2.验证提交的用户名密码是否正确.
    3.如果登陆成功,使用jwt颁发一个token给客户端,之后的客户端请求都要带上这个token.
    4.token验证:再自定义一个过滤器JWTAuthenticationFilter,当用户访问需要认证的请求时,拦截该请求,并进行token校验.


# 流程
    1. 在 MySecurityConfig  配置类头 加入 
        @Configuration
        @EnableWebSecurity // 开启 web 的安全模式
        @EnableGlobalMethodSecurity(prePostEnabled = true)
        
        Authentication  认证、身份认证
        Authorization   授权，批准;
        
        
# JWT 相关
    