#  springboot 跨域配置
    先把 yy-web 项目中的 GlobalCorsConfig 类 注释掉
    开启 xx-web 和 yy-web 前者向后者发起请求 浏览器 会提示 跨域警告 而且ajax 会走 error: function (data) 分支
    再把 yy-web 项目中的 GlobalCorsConfig 类 开启
    再次发起请求 浏览器的跨域警告没有了，而且ajax 会走 success: function (data) 分支


#CORS实现跨域访问 （局部跨域是会覆盖全局跨域的规则 ）
    全局CORS配置：
             方式1：返回新的 CorsFilter     注释掉 GlobalCorsConfig 类  使用 GlobalCorsConfig2  类 测试
             方式2：重写WebMvcConfigurer    注释掉 GlobalCorsConfig2 类  使用 GlobalCorsConfig  类 测试
    局部CORS配置
             方式3：使用注解（@CrossOrigin）
             方式4：手工设置响应头（HttpServletResponse ）