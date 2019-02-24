# Session： 
    概念： 服务器端会话技术,在一次会话的多次请求间 共享数据，将数据保存在服务器端的对象中。
    需要注意的是：
    @WebServlet(name = "sessionDemo01",urlPatterns = "/sessionDemo01") // 若没有设置 @WebServlet 的name属性，默认值会是Servlet的类完整名称
    如果不明确写出属性 比如这样：@WebServlet("fuck")   这将是 代表 urlPatterns 的属性  而不是 name 属性
    因为在 @WebServlet 注解的源码中 可以看到   * E.g. <code>@WebServlet("/path")}<br>  就代表了 他是 urlPatterns 的属性