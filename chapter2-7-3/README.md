# Spring的 RestTemplate访问使用了模版方法的设计模式.

    模版方法将过程中与特定实现相关的部分委托给接口,而这个接口的不同实现定义了接口的不同行为.
    RestTemplate定义了36个与REST资源交互的方法，其中的大多数都对应于HTTP的方法。 
    其实，这里面只有11个独立的方法，其中有十个有三种重载形式，而第十一个则重载了六次，这样一共形成了36个方法。
    
    delete()    在特定的URL上对资源执行HTTP DELETE操作
    exchange()  在URL上执行特定的HTTP方法，返回包含对象的ResponseEntity，这个对象是从响应体中映射得到的
    execute()   在URL上执行特定的HTTP方法，返回一个从响应体映射得到的对象
    getForEntity() 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象
    getForObject() 发送一个HTTP GET请求，返回的请求体将映射为一个对象
    postForEntity() POST 数据到一个URL，返回包含一个对象的ResponseEntity，这个对象是从响应体中映射得 到的
    postForObject() POST 数据到一个URL，返回根据响应体匹配形成的对象
    headForHeaders() 发送HTTP HEAD请求，返回包含特定资源URL的HTTP头
    optionsForAllow() 发送HTTP OPTIONS请求，返回对特定URL的Allow头信息
    postForLocation() POST 数据到一个URL，返回新创建资源的URL
    put() PUT 资源到特定的URL

# 返回值问题： RestTemplate.getForObject 和 RestTemplate.getForEntity
    ResponseEntity<List> forEntity = restTemplate.getForEntity(HOST + "/warehouseStockContentLog/getWarehouseLog1", List.class);
    List<T> list = restTemplate.getForObject(HOST + "/warehouseStockContentLog/getWarehouseLog2", List.class);
    使用以上两种方式 返回结果 ，不管这个T是什么，接收到都被转化为 LinkedHashMap
    
# 多系统之间 传输 json 数据问题：
     传输的 json 最终都要转成实体类 就涉及到 实体类主键id问题
     如果 是 接收的 json 转实体类中 的主键 id    与  数据库接收方 数据库 表中 对应的记录主键id 相同 
     那么 接收的该条实体类 则  update 本库表中 对应的记录   而不是  insert ！
     
     
# IDEA restClient 工具使用 注意事项：
    测试 POST 请求时候 要注意  再工具左侧的 Headers 中添加  Content-Type  ：  application/json
    
    如果后台是   public AjaxJson login(@RequestBody String jsonBody)  接收  
    那么 在工具右侧  TEXT 选项打钩 输入参入参数内容  json格式


# IntelliJ IDEA 项目结构旁边出现 0%classes,0% lines covered  测试 覆盖率
    直接 Ctrl+Alt+F6 弹出窗中删掉本次覆盖率测试