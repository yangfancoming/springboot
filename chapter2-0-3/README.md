# springboot 过滤器 实现方式
    1. 利用WebFilter注解配置
    2. FilterRegistrationBean方式 注册多个过滤器时 ，就注册多个FilterRegistrationBean即可
    
    
    过滤器：它是随web应用启动而启动的，只初始化一次，以后就可以拦截相关请求，只有当你的web应用停止或重新部署的时候才销毁
    拦截器：可以通过它来进行权限验证，或者判断用户是否登陆，或者是像12306 判断当前时间是否是购票时间
            对比一下其实goat可以发现，过滤器能做的事拦截器都能做，二拦截器做的事过滤器不一定做的了。
    监听器：其主要可用于以下方面：1、统计在线人数和在线用户2、系统启动时加载初始化信息3、统计网站访问量4、记录用户访问路径
    
# web 请求 拦截 顺序
        项目启动后 浏览器输入： http://localhost:8203/random1?what=123  测试 
        浏览器发起请求  filter放行前   interceptor(preHandle)  controller interceptor(postHandle)   前端页面  interceptor(afterCompletion)  filter放行后 



# 报错： Cannot create a session after the response has been committed
# 报错： javax.servlet.ServletException: Could not resolve view with name 'hello' in servlet with name 'dispatcherServlet' 
            在 application.properties 配置文件中 使用   以下配置无效
                spring.mvc.view.prefix=/WEB-INF/
                spring.mvc.view.suffix=.jsp
            但是 在启动类中使用 以下配置  则是OK的  这是为什么呢？ doit 
                
            @Bean
            public InternalResourceViewResolver setupViewResolver(){
                InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setPrefix("/WEB-INF/");
                resolver.setSuffix(".jsp");
                return resolver;
            }


# servlet 
    单例多线程 
    
    搭建步骤：
    
        1. 实现 servlet 接口
                实现 5个 方法
                    destroy
                    getServletConfig
                    getServletInfo
                    init
                    service
                    
        2.使用 @WebServlet 或 web.xml 中 指定 servlet 全限定类名、映射url 
                    
# Filter 过滤器
     定义：过滤器 可以过滤   请求资源 和 响应资源。 一来一回  都是可以进行过滤的！            
     拦截请求（request）可以修改请求头、请求内容等等。。
     拦截响应（response）  可以修改响应头


# Filter 生命周期
    1. 构造器  
    2. init() 初始化方法
    3. doFilter() 拦截
    4. destroy() 
    其中 1 和 2 只在项目启动时 执行一个  3是每次请求都执行   4是项目关闭时执行

# Filter url 匹配规则
    1.精确匹配
         CustomInterceptor1： @WebFilter(filterName = "FirstFilter", urlPatterns = { "/random1" })
         CustomInterceptor2：  urlList.add("/random2");
    2.路径匹配  /路径名/*
         参见： sos 注意*是必须的 否则拦截不生效的！ 
        
    3.后缀匹配   *.后缀名
         拦截所有以为 * 为后缀的请求
          参见：  urlPatterns = { "*.do" }
          
     注意： 三种匹配模式 不能混合使用！ eg： /page/*.jsp 则报错 
             