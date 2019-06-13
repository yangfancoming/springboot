# Spring MVC 体系架构
    SpringMVC流程
    1、  用户发送 url 请求至前端控制器 DispatcherServlet。
    2、  DispatcherServlet 收到请求调用 HandlerMapping 处理器映射器。 通过请求 url 找到对应的 HandlerAdapter 
    3、  HandlerMapping 处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给 DispatcherServlet。
    4、  DispatcherServlet 调用 HandlerAdapter 处理器适配器。
    5、  HandlerAdapter 经过适配调用具体的处理器(Controller，也叫后端控制器)。
    6、  Controller 执行完成返回 ModelAndView。
    7、  HandlerAdapter 将controller执行结果 ModelAndView 返回给 DispatcherServlet。
    8、  DispatcherServlet 将ModelAndView传给 ViewReslover 视图解析器。
    9、  ViewReslover 解析后返回具体 View。
    10、 DispatcherServlet 根据 View 进行渲染视图（即将model模型数据填充至视图中）。
    11、 DispatcherServlet 响应用户。
    
    
# MVC 框架 需要哪些功能？
    设置请求编码
    接收请求参数
    参数校检
    参数类型转换 (时间格式)
    将参数封装到对象/集合中
    设置共享数据
    文件上传/下载
    控制界面跳转
    自定义标签
    
    拦截器
    异常处理
    
    
# 执行流程
    1. 处理器映射器
        拿请求的url  根据 id/name(默认为函数名小写) 去匹配对应的 controller
        在传统的xml配置中 id/name 对应 <bean id = "xxx" class="com.goat.hello.HelloController"> 中的id
        在Springboot中是通过  @GetMapping("/hello") 注解加上方法上  将 url 与 bean 对应上的。
 
    2. 处理器适配器
    3. 视图解析器
    4. 处理器