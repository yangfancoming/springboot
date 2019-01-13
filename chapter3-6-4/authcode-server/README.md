# 1.增加依赖 
        <dependency>
            <groupId>org.springframework.security.oauth</groupId>
            <artifactId>spring-security-oauth2</artifactId>
            <version>2.3.2.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
# 2. 分别启用 三大组件
        @EnableAuthorizationServer // 启用授权服务器               
        @EnableResourceServer // 启用资源服务器
        @EnableWebSecurity // 启用 springsecurity

#  3. 获取授权码 
       http://localhost:3641/oauth/authorize?client_id=clientapp&redirect_uri=http://localhost:9001/callback&response_type=code&read_userinfo&scope=read_userinfo
       
       response_type：表示授权类型，必选项，此处的值固定为"code"
       client_id：表示客户端的ID，必选项
       redirect_uri：表示重定向URI，可选项
       scope：表示申请的权限范围，可选项
       state：表示客户端的当前状态，可以指定任意值，认证服务器会原封不动地返回这个值。
# 4. 获取成功后  跳转到 回调 uri        
       http://localhost:9001/callback?code=cESfM4
       
# 5. 通过 授权码 发 post 请求 来交换 access_token 

 
# 6. 通过 access_token  成功请求 http://localhost:3641/api/userinfo 