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