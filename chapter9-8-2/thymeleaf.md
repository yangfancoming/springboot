

    thymeleaf 默认路径 classpath:/templates/
    只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染；
    
# 报错： javax.servlet.ServletException: Circular view path 
    原因： 项目中 没有引入 thymeleaf 依赖。。。。

