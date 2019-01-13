package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer // 启用授权服务器
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 为了学习 演示效果 使用内存模式
        clients.inMemory()
              /* withClient 和 secret  为客户凭证  */
            .withClient("clientapp") // 支持客户端的名称
            .secret("{noop}112233")
            .redirectUris("http://localhost:9001/callback") // 重定向地址  (拿到授权码后跳转回客户端的地址)
            .authorizedGrantTypes("authorization_code","implicit","password") // 表示 授权服务器 支持授权码模式 和 简化模式 和 密码模式
            .accessTokenValiditySeconds(120) // token 有效期 120 秒
            .scopes("read_userinfo", "read_contacts"); // 给用户细分的权限


    }

}
