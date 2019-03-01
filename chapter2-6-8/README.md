# 项目启动后： Tomcat 报错 Caused by: java.lang.Exception: Socket bind failed: [730048]
    解决方法： 是端口号被占用了，修改完以后，问题成功解决！
    
# 页面加入 table 模块 使用js 渲染时 页面报错：
    Caused by: org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as expression: "
                    {field:'id', width:80, title: 'ID', sort: true}
                    ,{field:'username', width:80, title: '用户名'}
                    ,{field:'sex', width:80, title: '性别', sort: true}
                    ,{field:'city', width:80, title: '城市'}
                    
     解决方式：
     1.也就是把cols后的[[ ]]变为
         [
         [
         ]
         ]
     因为[[…]]之间的表达式在thymeleaf被认为是内联表达式,所以渲染错误
     
     2.或者在<script type="text/javascript" >  加上 th:inline="none"
     <script type="text/javascript"  th:inline="none">
     但是这样的话，前面在base中使用[[@{}]]的标签也不能解析了，所以还是使用第一种方案，以后可以根据情况来解决。
