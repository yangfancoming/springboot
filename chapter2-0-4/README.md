# Session： 
    实现原理： Session的实现 是依赖于 cookie 的
    概念： 服务器端会话技术,在一次会话的多次请求间 共享数据，将数据保存在服务器端的对象中。
    需要注意的是：
    @WebServlet(name = "sessionDemo01",urlPatterns = "/sessionDemo01") // 若没有设置 @WebServlet 的name属性，默认值会是Servlet的类完整名称
    如果不明确写出属性 比如这样：@WebServlet("fuck")   这将是 代表 urlPatterns 的属性  而不是 name 属性
    因为在 @WebServlet 注解的源码中 可以看到   * E.g. <code>@WebServlet("/path")}<br>  就代表了 他是 urlPatterns 的属性
    
# 细节
    1.当客户端(浏览器)关闭后，服务器不关闭，两次获取的session 并不是同一个！  （默认情况下）
        解决方法： Cookie cookie = new Cookie("JSESSIONID",session.getId());
    2.当客户端(浏览器)不关闭，服务器关闭，两次获取的session 并不是同一个！
        解决方法： 
            session 钝化(序列化)： 在服务器正常关闭之前，将 session 对象 序列化到磁盘上
            session 活化(烦序列化)： 在服务器启动后，将 session 文件 转换为内容中的 session 对象即可
            
        
    3.session 销毁
        1. 服务器关闭
        2. session对象调用 session.invalidate();
        3. session 的失效时间