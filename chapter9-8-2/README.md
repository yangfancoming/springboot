#   项目启动后  http://localhost:8982/thymeleaf/test1
    static/js/init.js  文件中 
    1.发起左侧菜单 请求  type: 'POST', url: "/menu" , data: {} ,
    2.发起 工作台主页  请求 Core.load("#content","/workdest");
    2.login.html  页  请求 /verificationCode
    
    用户登录后 KickoutSessionControlFilter 类中的 
    Deque<Serializable> deque = cache.get(username);  将用户名写入缓存
    
# 项目报错：
     Exception evaluating SpringEL expression: "@perms.hasPerm('user:edit')" (template: "user/list" - line 162, col 23)
     A problem occurred when trying to resolve bean 'perms':'Could not resolve bean reference against BeanFactory'
     org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'perms' available
     
     是由于 没有引入 com.goat.doit.shiro.PermsService 类。。。
    
    
    解决 用户登录后  用户信息没有存入redis的问题   ShiroConfig中的 过滤连问题
    是 ShiroConfig 类中 Map<String,String> filterChainDefinitionMap = shiroService.loadFilterChainDefinitions(); 这里的问题  请参看 两次git提交 变化的部分 