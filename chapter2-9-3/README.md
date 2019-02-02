#  springboot 跨域配置
    先把 yy-web 项目中的 GlobalCorsConfig 类 注释掉
    开启 xx-web 和 yy-web 前者向后者发起请求 浏览器 会提示 跨域警告 而且ajax 会走 error: function (data) 分支
    再把 yy-web 项目中的 GlobalCorsConfig 类 开启
    再次发起请求 浏览器的跨域警告没有了，而且ajax 会走 success: function (data) 分支
